#include <windows.h>
#include <stdio.h>
#include <conio.h>

void SendKeyPress(BYTE vkCode) {
    // Нажатие клавиши
    keybd_event(vkCode, 0, 0, 0);
    // Отпускание клавиши
    keybd_event(vkCode, 0, KEYEVENTF_KEYUP, 0);
}

int main() {
    printf("Auto Keyboard Presser v2.0\n");
    printf("Press the key you want to auto-repeat (or Esc to quit): ");
    
    int key = _getch();
    if (key == 27) {
        printf("\nCancelled by user.\n");
    }
    
    BYTE vkCode = LOBYTE(VkKeyScanA(key));
    printf("\nSelected key: '%c' (Virtual Key: 0x%X)\n", key, vkCode);
    
    printf("Enter press interval in milliseconds (1000 = 1 second): ");
    DWORD interval;
    if (scanf("%lu", &interval) != 1 || interval < 10) {
        printf("Invalid interval! Using default 200ms.\n");
        interval = 200;
    }
    
    printf("Press F12 to stop the auto-pressing...\n");
    printf("Auto-pressing started!\n");
    
    // Очистка буфера клавиатуры
    while (_kbhit()) _getch();
    
    // Основной цикл
    while (1) {
        // Проверка на F12
        if (GetAsyncKeyState(VK_F12) & 0x8000) {
            printf("\nStopped by user.\n");
            break;
        }
        
        SendKeyPress(vkCode);
        
        // Задержка с периодической проверкой F12
        for (DWORD i = 0; i < interval; i += 50) {
            if (GetAsyncKeyState(VK_F12) & 0x8000) {
                printf("\nStopped by user.\n");
                return 0;
            }
            Sleep(50);
        }
    }
    
}