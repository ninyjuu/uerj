package lp2g13.bib;

public class Biblioteca implements Serializable{
    import java.io.*;
    import java.util.*;
    import java.text.SimpleDateFormat;
    import java.util.stream.Collectors;

    public class Biblioteca implements Serializable {
        
        private HashMap<Long, Usuario> cadastroUsuarios;
        private HashMap<Integer, Livro> cadastroLivros;

        public Biblioteca() {
            this.cadastroUsuarios = new HashMap<>();
            this.cadastroLivros = new HashMap<>();
        }

        public Biblioteca(String arqUsuarios, String arqLivros) {
            this.cadastroUsuarios = new HashMap<>();
            this.cadastroLivros = new HashMap<>();
            
            leArquivo(arqUsuarios, "usuario");
            leArquivo(arqLivros, "livro");
        }
        
        public void cadastraUsuario(Usuario usuario) {
            long cpf = usuario.getNumCPF();
            if (cadastroUsuarios.containsKey(cpf)) {
                System.err.println("Erro: Usuario com CPF " + cpf + " ja cadastrado.");
                return;
            }
            cadastroUsuarios.put(cpf, usuario);
        }

        public void cadastraLivro(Livro livro) {
            int cod = livro.getCodLivro();
            if (cadastroLivros.containsKey(cod)) {
                System.err.println("Erro: Livro com codigo " + cod + " ja cadastrado.");
                return;
            }
            cadastroLivros.put(cod, livro);
        }

        public void salvaArquivo(HashMap<?, ?> map, String nomeArquivo) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
                oos.writeObject(map);
                System.out.println("Dados salvos com sucesso em: " + nomeArquivo);
            } catch (IOException e) {
                System.err.println("Erro ao salvar arquivo " + nomeArquivo + ": " + e.getMessage());
            }
        }

        public void leArquivo(String nomeArquivo, String tipo) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
                Object obj = ois.readObject();
                
                if (tipo.equalsIgnoreCase("usuario") && obj instanceof HashMap) {
                    this.cadastroUsuarios = (HashMap<Long, Usuario>) obj;
                    System.out.println("Cadastro de usuarios carregado de: " + nomeArquivo);
                } else if (tipo.equalsIgnoreCase("livro") && obj instanceof HashMap) {
                    this.cadastroLivros = (HashMap<Integer, Livro>) obj;
                    System.out.println("Acervo de livros carregado de: " + nomeArquivo);
                } else {
                    System.err.println("Erro: Arquivo " + nomeArquivo + " contem tipo de objeto inesperado.");
                }
            } catch (FileNotFoundException e) {
                System.err.println("Aviso: Arquivo " + nomeArquivo + " nao encontrado. Criando novo cadastro.");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Erro ao ler arquivo " + nomeArquivo + ": " + e.getMessage());
            }
        }
        
        public Livro getLivro(int cod) throws LivroNaoCadastradoEx {
            if (!cadastroLivros.containsKey(cod)) {
                throw new LivroNaoCadastradoEx("Livro com codigo " + cod + " nao cadastrado.");
            }
            return cadastroLivros.get(cod);
        }

        public Usuario getUsuario(long CPF) throws UsuarioNaoCadastradoEx {
            if (!cadastroUsuarios.containsKey(CPF)) {
                throw new UsuarioNaoCadastradoEx("Usuario com CPF " + CPF + " nao cadastrado.");
            }
            return cadastroUsuarios.get(CPF);
        }

        public void emprestaLivro(Usuario usuario, Livro livro) throws CopiaNaoDisponivelEx {
            GregorianCalendar dataAtual = new GregorianCalendar();
            
            livro.empresta(); 

            livro.addUsuarioHist(dataAtual, null, usuario.getNumCPF()); 

            usuario.addLivroHist(dataAtual, livro.getCodLivro());
            
            System.out.println("Emprestimo realizado com sucesso. Livro: " + livro.getTitulo() + " para: " + usuario.getNome());
        }

        public void devolveLivro(Usuario usuario, Livro livro) throws NenhumaCopiaEmprestadaEx {
            GregorianCalendar dataDevolucao = new GregorianCalendar();
            
            livro.devolve(); 

            boolean usuarioHistAtualizado = false;
            for (Emprest emprest : usuario.getHist()) {
                if (emprest.getCodLivro() == livro.getCodLivro() && emprest.getDataDevolucao() == null) {
                    emprest.setDataDevolucao(dataDevolucao);
                    usuarioHistAtualizado = true;
                    
                    long diasEmprestimo = (dataDevolucao.getTimeInMillis() - emprest.getDataEmprest().getTimeInMillis()) / (1000 * 60 * 60 * 24);
                    if (diasEmprestimo > 7) { 
                        System.out.println("\nAviso de Multa: Livro devolvido com " + diasEmprestimo + " dias de atraso.");
                    }
                    break;
                }
            }
            
            boolean livroHistAtualizado = false;
            for (EmprestPara emprestPara : livro.getHist()) {
                if (emprestPara.getCpfUsuario() == usuario.getNumCPF() && emprestPara.getDataDevolucao() == null) {
                    emprestPara.setDataDevolucao(dataDevolucao);
                    livroHistAtualizado = true;
                    break;
                }
            }
            
            if (usuarioHistAtualizado && livroHistAtualizado) {
                System.out.println("Devolucao concluida com sucesso. Livro: " + livro.getTitulo());
            } else {
                System.err.println("Erro: Nao foi possivel encontrar o registro de emprestimo pendente para atualizar a devolucao.");
            }
        }

        public String imprimeLivros() {
            if (cadastroLivros.isEmpty()) return "Nenhum livro cadastrado.";
            
            return cadastroLivros.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(e -> e.getValue().toString() + "\n---")
                .collect(Collectors.joining("\n"));
        }

        public String imprimeUsuarios() {
            if (cadastroUsuarios.isEmpty()) return "Nenhum usuario cadastrado.";
            
            return cadastroUsuarios.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .map(e -> e.getValue().toString() + "\n---")
                .collect(Collectors.joining("\n"));
        }
        
        public HashMap<Long, Usuario> getCadastroUsuarios() { return cadastroUsuarios; }
        public HashMap<Integer, Livro> getCadastroLivros() { return cadastroLivros; }
    }
}