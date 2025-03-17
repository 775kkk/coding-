#include <stdio.h>
#include <stdlib.h>

void rle_compress(const char *src, const char *dst) {
    FILE *in = fopen(src, "rb");
    FILE *out = fopen(dst, "wb");

    if (!in || !out) {
        perror("File error");
        exit(EXIT_FAILURE);
    }

    int count;
    unsigned char current, previous;

    if (fread(&previous, sizeof(unsigned char), 1, in) != 1) {
        fclose(in);
        fclose(out);
        return;
    }

    count = 1;
    while (fread(&current, sizeof(unsigned char), 1, in) == 1) {
        if (current == previous) {
            count++;
        } else {
            fwrite(&count, sizeof(int), 1, out);
            fwrite(&previous, sizeof(unsigned char), 1, out);
            previous = current;
            count = 1;
        }
    }

    fwrite(&count, sizeof(int), 1, out);
    fwrite(&previous, sizeof(unsigned char), 1, out);

    fclose(in);
    fclose(out);
}

int main() {
    rle_compress("input.txt", "output.rle");
    return 0;
}