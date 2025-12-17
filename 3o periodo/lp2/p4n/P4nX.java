import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import lp2g13.bib.*;

public class P4nX extends JFrame {
    private Biblioteca bib;
    private JTable tabelaUsuarios, tabelaLivros;
    private DefaultTableModel modelUsuarios, modelLivros;
    private JTextField txtLivroCod, txtUserCpf;
    private JRadioButton rbEmprestar, rbDevolver;

    public P4nX() {
        try {
            bib = new Biblioteca("u.dat", "l.dat");
            JOptionPane.showMessageDialog(this, "Arquivos carregados com sucesso!");
        } catch (Exception e) {
            bib = new Biblioteca();
            JOptionPane.showMessageDialog(this, "Erro ao carregar arquivos. Iniciando biblioteca vazia.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        setTitle("Manutenção - Sistema de Biblioteca@VM14");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel painelNorte = new JPanel(new GridLayout(1, 3, 10, 10));
        painelNorte.add(criarPainelEmprestimo());
        painelNorte.add(criarPainelCadastro());
        painelNorte.add(criarPainelRelatorio());
        add(painelNorte, BorderLayout.NORTH);

        JTabbedPane abas = new JTabbedPane();
        abas.addTab("Usuários", criarPainelTabelaUsuarios());
        abas.addTab("Livros", criarPainelTabelaLivros());
        add(abas, BorderLayout.CENTER);

        atualizarTabelas();
    }

    private JPanel criarPainelEmprestimo() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBorder(new TitledBorder("Empréstimo:"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0; painel.add(new JLabel("Livro (Cod):"), gbc);
        gbc.gridx = 1; txtLivroCod = new JTextField(10); painel.add(txtLivroCod, gbc);

        gbc.gridx = 0; gbc.gridy = 1; painel.add(new JLabel("Usuário (CPF):"), gbc);
        gbc.gridx = 1; txtUserCpf = new JTextField(10); painel.add(txtUserCpf, gbc);

        rbEmprestar = new JRadioButton("Emprestar", true);
        rbDevolver = new JRadioButton("Devolver");
        ButtonGroup group = new ButtonGroup();
        group.add(rbEmprestar); group.add(rbDevolver);

        gbc.gridx = 0; gbc.gridy = 2; painel.add(rbEmprestar, gbc);
        gbc.gridx = 0; gbc.gridy = 3; painel.add(rbDevolver, gbc);

        JButton btnEfetuar = new JButton("Efetuar");
        gbc.gridx = 1; gbc.gridy = 3; painel.add(btnEfetuar, gbc);
        btnEfetuar.addActionListener(e -> executarTransacao());

        return painel;
    }

    private JPanel criarPainelCadastro() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBorder(new TitledBorder("Cadastro:"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton btnCadLivro = new JButton("Cadastrar livro");
        JButton btnCadUser = new JButton("Cadastrar usuário");

        btnCadLivro.addActionListener(e -> abrirJanelaCadastroLivro());
        btnCadUser.addActionListener(e -> abrirJanelaCadastroUsuario());

        gbc.gridx = 0; gbc.gridy = 0; painel.add(btnCadLivro, gbc);
        gbc.gridx = 0; gbc.gridy = 1; painel.add(btnCadUser, gbc);

        return painel;
    }

    private JPanel criarPainelRelatorio() {
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBorder(new TitledBorder("Relatório:"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton btnAtualizar = new JButton("Atualizar tabelas");
        JButton btnHistUser = new JButton("Histórico de usuário...");
        JButton btnHistLivro = new JButton("Histórico de livro...");

        gbc.gridx = 0; gbc.gridy = 0; painel.add(btnAtualizar, gbc);
        gbc.gridx = 0; gbc.gridy = 1; painel.add(btnHistUser, gbc);
        gbc.gridx = 0; gbc.gridy = 2; painel.add(btnHistLivro, gbc);

        btnAtualizar.addActionListener(e -> atualizarTabelas());
        btnHistUser.addActionListener(e -> exibirHistoricoUsuario());
        btnHistLivro.addActionListener(e -> exibirHistoricoLivro());

        return painel;
    }

    private void abrirJanelaCadastroLivro() {
        JDialog janela = new JDialog(this, "Cadastrando livro:", true);
        janela.setSize(400, 300);
        janela.setLayout(new GridLayout(5, 2, 10, 10));
        janela.setLocationRelativeTo(this);

        JTextField txtC = new JTextField(); JTextField txtT = new JTextField();
        JTextField txtCat = new JTextField(); JTextField txtQ = new JTextField();

        janela.add(new JLabel("Codigo:")); janela.add(txtC);
        janela.add(new JLabel("Titulo:")); janela.add(txtT);
        janela.add(new JLabel("Categoria:")); janela.add(txtCat);
        janela.add(new JLabel("Copias:")); janela.add(txtQ);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(ev -> {
            try {
                int c = Integer.parseInt(txtC.getText());
                int q = Integer.parseInt(txtQ.getText());
                bib.cadastraLivro(new Livro(c, txtT.getText(), txtCat.getText(), q, 0));
                atualizarTabelas();
                janela.dispose();
            } catch (Exception ex) { JOptionPane.showMessageDialog(janela, "Erro nos dados."); }
        });

        janela.add(new JLabel()); janela.add(btnSalvar);
        janela.setVisible(true);
    }

    private void abrirJanelaCadastroUsuario() {
        JDialog janela = new JDialog(this, "Cadastrando usuário:", true);
        janela.setSize(450, 400);
        janela.setLayout(new GridLayout(6, 2, 10, 10));
        janela.setLocationRelativeTo(this);

        JTextField tN = new JTextField(); JTextField tS = new JTextField();
        JTextField tC = new JTextField(); JTextField tD = new JTextField();
        JTextField tE = new JTextField();

        janela.add(new JLabel("Nome:")); janela.add(tN);
        janela.add(new JLabel("Sobrenome:")); janela.add(tS);
        janela.add(new JLabel("CPF:")); janela.add(tC);
        janela.add(new JLabel("Data Nasc (dd/mm/aaaa):")); janela.add(tD);
        janela.add(new JLabel("Endereço:")); janela.add(tE);

        JButton btnS = new JButton("Salvar");
        btnS.addActionListener(ev -> {
            try {
                String dataInput = tD.getText().trim();
                String[] partes = dataInput.contains("/") ? dataInput.split("/") : dataInput.split(" ");
                if (partes.length != 3) throw new Exception("Formato inválido");

                int dia = Integer.parseInt(partes[0]);
                int mes = ValidaData.converteMes(partes[1]);
                if (mes == -1) mes = Integer.parseInt(partes[1]);
                int ano = Integer.parseInt(partes[2]);

                if (ValidaData.validarDataCompleta(dia, mes, ano)) {
                    GregorianCalendar gc = new GregorianCalendar(ano, mes - 1, dia);
                    bib.cadastraUsuario(new Usuario(tN.getText(), tS.getText(), gc, Long.parseLong(tC.getText()), tE.getText()));
                    atualizarTabelas();
                    janela.dispose();
                    JOptionPane.showMessageDialog(this, "Usuário cadastrado!");
                } else {
                    JOptionPane.showMessageDialog(janela, "Data de nascimento inválida conforme regras do calendário.");
                }
            } catch (Exception ex) { JOptionPane.showMessageDialog(janela, "Erro nos dados ou formato de data."); }
        });

        janela.add(new JLabel()); janela.add(btnS);
        janela.setVisible(true);
    }

    private void executarTransacao() {
        try {
            Usuario u = bib.getUsuario(Long.parseLong(txtUserCpf.getText()));
            Livro l = bib.getLivro(Integer.parseInt(txtLivroCod.getText()));
            if (rbEmprestar.isSelected()) bib.emprestaLivro(u, l);
            else bib.devolveLivro(u, l);
            atualizarTabelas();
            JOptionPane.showMessageDialog(this, "Operação realizada com sucesso!");
        } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage()); }
    }

    private void exibirHistoricoUsuario() {
        String s = JOptionPane.showInputDialog(this, "Digite o CPF do usuário:");
        if (s == null) return;
        try {
            Usuario u = bib.getUsuario(Long.parseLong(s));
            StringBuilder sb = new StringBuilder("Histórico de " + u.getNome() + ":\n");
            u.getHist().forEach(h -> sb.append(h.toString()).append("\n"));
            JOptionPane.showMessageDialog(this, sb.length() > 20 ? sb.toString() : "Nenhum registro encontrado.");
        } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Usuário não encontrado."); }
    }

    private void exibirHistoricoLivro() {
        String s = JOptionPane.showInputDialog(this, "Digite o Código do livro:");
        if (s == null) return;
        try {
            Livro l = bib.getLivro(Integer.parseInt(s));
            StringBuilder sb = new StringBuilder("Histórico de " + l.getTitulo() + ":\n");
            l.getHist().forEach(h -> sb.append(h.toString()).append("\n"));
            JOptionPane.showMessageDialog(this, sb.length() > 20 ? sb.toString() : "Nenhum registro encontrado.");
        } catch (Exception ex) { JOptionPane.showMessageDialog(this, "Livro não encontrado."); }
    }

    private JPanel criarPainelTabelaUsuarios() {
        JPanel p = new JPanel(new BorderLayout());
        modelUsuarios = new DefaultTableModel(new String[]{"Nome", "Sobrenome", "Data Nasc.", "CPF", "Endereço"}, 0);
        tabelaUsuarios = new JTable(modelUsuarios);
        tabelaUsuarios.setAutoCreateRowSorter(true);
        p.add(new JScrollPane(tabelaUsuarios), BorderLayout.CENTER);
        return p;
    }

    private JPanel criarPainelTabelaLivros() {
        JPanel p = new JPanel(new BorderLayout());
        modelLivros = new DefaultTableModel(new String[]{"Código", "Título", "Categoria", "Cópias", "Emprestados"}, 0);
        tabelaLivros = new JTable(modelLivros);
        tabelaLivros.setAutoCreateRowSorter(true);
        p.add(new JScrollPane(tabelaLivros), BorderLayout.CENTER);
        return p;
    }

    private void atualizarTabelas() {
        modelUsuarios.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        bib.getCadastroUsuarios().values().forEach(u -> modelUsuarios.addRow(new Object[]{
            u.getNome(), u.getSobreNome(), 
            u.getDataNasc() != null ? sdf.format(u.getDataNasc().getTime()) : "N/A", 
            u.getNumCPF(), u.getEndereco()
        }));
        modelLivros.setRowCount(0);
        bib.getCadastroLivros().values().forEach(l -> modelLivros.addRow(new Object[]{
            l.getCodLivro(), l.getTitulo(), l.getCategoria(), l.getQuantidade(), l.getEmprestados()
        }));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new P4nX().setVisible(true));
    }
}