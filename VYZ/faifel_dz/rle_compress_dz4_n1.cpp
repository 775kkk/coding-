#include <stdio.h>
#include <stdlib.h>

void rle_compress(const char *src, const char *dst) {
    FILE *in = fopen(src, "rb");
    FILE *out = fopen(dst, "wb");

    if (!in || !out) {
        printf("read error\n");
        return;
    }

    int count = 1;
    unsigned char current, previous;

    if (fread(&previous, 1, 1, in) != 1) {
        fclose(in);
        fclose(out);
        return;
    }

    while (fread(&current, 1, 1, in) == 1) {
        if (current == previous) {
            count++;
        } else {
            fwrite(&count, 1, 1, out);
            fwrite(&previous, 1, 1, out);
            previous = current;
            count = 1;
        }
    }

    fwrite(&count, 1, 1, out);
    fwrite(&previous, 1, 1, out);

    fclose(in);
    fclose(out);
    printf("normalek\n");
}

int main() {
    rle_compress("input.txt", "output.rle");
}