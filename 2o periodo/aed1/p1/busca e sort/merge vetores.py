def mergeVetores(V1, V2):
    i, j, k = 0, 0, -1
    n, m = len(V1), len(V2)
    V3 = [0] * (n + m)

    while i < n and j < m:
        k = k + 1
        if V1[i] < V2[j]:
            V3[k] = V1[i]
            i = i + 1
        else:
            V3[k] = V2[j]
            j = j + 1

    while i < n:
        k = k + 1
        V3[k] = V1[i]
        i = i + 1

    while j < m:
        k = k + 1
        V3[k] = V2[j]
        j = j + 1

    return V3
