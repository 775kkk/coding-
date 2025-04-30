#include <windows.h>
#include <stdio.h>
#include <conio.h>

// Значения по умолчанию
#define DEFAULT_KEY 'v'
#define DEFAULT_INTERVAL 1100

void SendKeyPress(BYTE vkCode) {
    keybd_event(vkCode, 0, 0, 0);
    keybd_event(vkCode, 0, KEYEVENTF_KEYUP, 0);
}

int main() {
    // Установка значений по умолчанию
    char selectedKey = DEFAULT_KEY;
    DWORD interval = DEFAULT_INTERVAL;
    
    printf("Auto Keyboard Presser (Default: Key='%c', Interval=%lums)\n", 
           DEFAULT_KEY, DEFAULT_INTERVAL);
    printf("Press ENTER to use defaults, or any key to customize...\n");
    
    
    
    BYTE vkCode = LOBYTE(VkKeyScanA(selectedKey));
    printf("\nConfigured: Key='%c' (0x%X), Interval=%lums\n", 
           selectedKey, vkCode, interval);
    printf("Press F12 to stop...\n");
    
    while (!(GetAsyncKeyState(VK_F12) & 0x8000)) {
        SendKeyPress(vkCode);
        
        // Задержка с проверкой F12 каждые 50мс
        for (DWORD i = 0; i < interval && !(GetAsyncKeyState(VK_F12) & 0x8000); i += 50) {
            Sleep(50);
        }
        
        if (GetAsyncKeyState(VK_F12) & 0x8000) break;
    }
    
    printf("\nAuto-pressing stopped.\n");
    return 0;
}