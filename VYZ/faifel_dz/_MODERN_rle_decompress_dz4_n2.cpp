#include <stdio.h>
#include <stdlib.h>

void rle_decompress(const char *src, const char *dst) {
    FILE *in = fopen(src, "rb");
    FILE *out = fopen(dst, "wb");

    if (!in || !out) {
        perror("File error");
        exit(EXIT_FAILURE);
    }

    int count;
    unsigned char value;

    while (fread(&count, sizeof(int), 1, in) == 1) {
        if (fread(&value, sizeof(unsigned char), 1, in) != 1) {
            perror("File read error");
            fclose(in);
            fclose(out);
            exit(EXIT_FAILURE);
        }
        for (int i = 0; i < count; i++) {
            if (fputc(value, out) == EOF) {
                perror("File write error");
                fclose(in);
                fclose(out);
                exit(EXIT_FAILURE);
            }
        }
    }

    fclose(in);
    fclose(out);
}

int main() {
    rle_decompress("output.rle", "decompressed.txt");
    return 0;
}