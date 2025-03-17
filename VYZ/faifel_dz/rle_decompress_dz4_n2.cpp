#include <stdio.h>

void rle_decompress(const char *src, const char *dst) {
    FILE *in = fopen(src, "rb");
    FILE *out = fopen(dst, "wb");

    if (!in || !out) {
        printf("read error\n");
        return;
    }

    int count;
    unsigned char value;

    while (fread(&count, 1, 1, in) == 1) {
        if (fread(&value, 1, 1, in) != 1) {
            printf("read error\n");
            fclose(in);
            fclose(out);
            return;
        }
        for (int i = 0; i < count; i++) {
            fwrite(&value, 1, 1, out);
        }
    }

    fclose(in);
    fclose(out);
    printf("normalek\n");
}

int main() {
    rle_decompress("output.rle", "decompressed.txt");
}