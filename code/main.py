import sys

line = sys.stdin.readline().strip()
a, b = line.split(" ")
print(int(a) * int(b))


def count_pairs(a, b, n):
    odd1 = 0
    even1 = 0
    odd2 = 0
    even2 = 0

    for i in range(n):
        if a[i] % 2 == 1:
            odd1 += 1
        else:
            even1 += 1

        if b[i] % 2 == 1:
            odd2 += 1
        else:
            even2 += 1
    pairs = min(odd1, odd2) + min(even1, even2)

    return pairs


int count_pairs(int a[], int b[], int N)
{
    int odd1 = 0, even1 = 0;
    int odd2 = 0, even2 = 0;
    for (int i = 0; i < N; i++) {
        if (a[i] % 2 == 1)
            odd1++;
        else
            even1++;
        if (b[i] % 2 == 1)
            odd2++;
        else
            even2++;
    }
    int pairs = min(odd1, odd2) + min(even1, even2);
    return pairs;
}