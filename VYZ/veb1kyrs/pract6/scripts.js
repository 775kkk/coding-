window.onload = function () {
    displayTask1_9_data();
    displayTask1_8_data()
};

function task1_1() {
            let results = [
                `true + false = ${true + false}`,
                `12 / "6" = ${12 / "6"}`,
                `"number" + 15 + 3 = ${"number" + 15 + 3}`,
                `15 + 3 + "number" = ${15 + 3 + "number"}`,
                `'1' > null = ${'1' > null}`,
                `'true' == true = ${'true' == true}`,
                `false == 'false' = ${false == 'false'}`,
                `null == '' = ${null == ''}`
            ];
            
            document.getElementById('task1_1_result').innerHTML = 
                '<pre>' + results.join('\n') + '</pre>';
        }

        // 1.2
        function task1_2() {
            let variable = prompt("введите любое значение:");
            let type = typeof variable;
            let message;
            
            if (variable === null) {
                message = "вы отменили ввод";
            } else if (type === "string") {
                message = "это строка: " + variable;
            } else if (type === "number") {
                message = "это число: " + variable;
            } else if (type === "boolean") {
                message = "это булево значение: " + variable;
            } else {
                message = "это другой тип: " + type;
            }
            
            document.getElementById('task1_2_result').textContent = message;
        }

        // 1.3
        function task1_3() {
            let zodiac = prompt("введите ваш знак зодиака:");
            
            if (zodiac === null) {
                alert("вы отменили ввод");
                return;
            }
            
            switch(zodiac.toLowerCase()) {
                case "овен":
                    alert("овен первый знак зодиака вы полны энергии и энтузиазма");
                    break;
                case "телец":
                    alert("телец знак земли вы надежны и практичны");
                    break;
                case "близнецы":
                    alert("близнецы знак воздуха вы общительны и любознательны ");
                    break;
                case "рак":
                    alert("рак водный знак вы эмоциональны и интуитивны");
                    break;
                case "лев":
                    alert("лев огненный знак вы уверены в себе и харизматичны");
                    break;
                case "дева":
                    alert("дева знак земли вы внимательны к деталям и аналитичны");
                    break;
                case "весы":
                    alert("аесы знак воздуха вы дипломатичны и стремитесь к гармонии");
                    break;
                case "скорпион":
                    alert("скорпион водный знак вы страстны и проницательны");
                    break;
                case "стрелец":
                    alert("стрелец огненный знак вы оптимистичны и любите приключения");
                    break;
                case "козерог":
                    alert("козерог знак земли вы дисциплинированы и амбициозны");
                    break;
                case "водолей":
                    alert("водолей знак воздуха вы оригинальны и гуманистичны");
                    break;
                case "рыбы":
                    alert("рыбы водный знак вы сострадательны и обладаете богатым воображением");
                    break;
                default:
                    alert("unkown знак" + zodiac);
            }
        }

        // 1.4
        function task1_4() {
            let n = prompt("введите число n");
            
            if (n === null || isNaN(n)) {
                document.getElementById('task1_4_result').textContent = "некорректный ввод";
                return;
            }
            
            n = parseInt(n);
            let sumFor = 0, sumWhile = 0, sumDoWhile = 0;
            
            for (let i = 1; i <= n; i++) {
                sumFor += i;
            }
            
            let j = 1;
            while (j <= n) {
                sumWhile += j;
                j++;
            }

            let k = 1;
            do {
                sumDoWhile += k;
                k++;
            } while (k <= n);
            
            document.getElementById('task1_4_result').innerHTML = `
                Сумма чисел от 1 до ${n}:<br>
                -for: ${sumFor}<br>
                -while: ${sumWhile}<br>
                -do-while: ${sumDoWhile}
            `;
        }

        // 1.5
        function task1_5() {
            let result = "";
            for (let i = 0; i <= 15; i++) {
                result += `${i} - ${i % 2 === 0 ? "чет" : "нечет"}\n`;
            }
            document.getElementById('task1_5_result').innerHTML = 
                '<pre>' + result + '</pre>';
        }

        // 1.6
        function task1_6() {
            let number;
            do {
                number = prompt("введи число больше 5 ");
                if (number === null) {
                    alert("вы отменили ввод");
                    return;
                }
                number = parseFloat(number);
            } while (isNaN(number) || number <= 5);
            
            alert(`поздравляем! вы ввели ${number}, больше 5`);
        }

        // 1.7
        function task1_7() {
            let rows = 5;
            let result = "";
            
            for (let i = 1; i <= rows; i++) {
                for (let j = 1; j <= i; j++) {
                    result += "* ";
                }
                result += "<br>";
            }
            
            document.getElementById('task1_7_result').innerHTML = result;
        }

        let task1_8_mass1 = [1, 2, 3, 4, 5, 6];
        let task1_8_mass2 = new Array(7, 8, 9);
        let task1_8_mass3 = Array.of('a', 'b', 'c', 'd', 'e');

    function displayTask1_8_data() {
        const el = document.getElementById("task1_8_data");
        if (el) {
            el.textContent = `массив 1: [ ${task1_8_mass1.join(", ")} ] , массив 2: [ ${task1_8_mass2.join(", ")} ] , массив 3: [ ${task1_8_mass3.join(", ")} ]`;
        }
    }

// 1.8 работа с массивами создание, доступ, перебор
    function task1_8() {
        // task1_8_mass1
        // task1_8_mass2
        // task1_8_mass3

        let arr = task1_8_mass1;

        alert(`5 элемент: ${arr[4]}`);
        arr[4] = 99423424;
        alert(`новый элемент 5: ${arr[4]}`);

        alert(`длина : ${arr.length}`);

        // for
        let result1 = "вывод for:\n";
        for (let i = 0; i < arr.length; i++) {
            result1 += `arr[${i}] = ${arr[i]}\n`;
        }

        // forEach
        let result2 = "вывод forEach:\n";
        arr.forEach((value, index) => {
            result2 += `arr[${index}] = ${value}\n`;
        });

        alert(result1 + '\n' + result2);
        displayTask1_8_data()
}


    // Глобальный массив
    let task1_9_data = [10, 20, 30, 40, 50];

    // Функция для отображения массива
    function displayTask1_9_data() {
        const el = document.getElementById("task1_9_data");
        if (el) {
            el.textContent = `Текущий массив: [ ${task1_9_data.join(", ")} ]`;
        }
    }

    // Задание 1.9: Операции над массивом через switch
        function task1_9() {

        let choice = prompt(
            `Выберите операцию:
            1 - Добавить элемент в начало
            2 - Добавить элемент в конец
            3 - Удалить первый элемент
            4 - Удалить последний элемент
            5 - Добавить элемент по индексу
            6 - Удалить элемент по индексу
            7 - Изменить элемент по индексу`
        );

        if (choice === null) return;

        switch (choice) {
            case "1": {
                let first = prompt("введите элемент для добавления в начало:");
                task1_9_data.unshift(first);
                break;
            }
            case "2": {
                let last = prompt("введите элемент для добавления в конец:");
                task1_9_data.push(last);
                break;
            }
            case "3": {
                task1_9_data.shift();
                break;
            }
            case "4": {
                task1_9_data.pop();
                break;
            }
            case "5": {
                let indexAdd = parseInt(prompt("введите индекс"));
                let elemAdd = prompt("введите элемент");
                if (!isNaN(indexAdd) && indexAdd >= 0 && indexAdd <= task1_9_data.length) {
                    task1_9_data.splice(indexAdd, 0, elemAdd);
                } else {
                    alert("неверный индекс");
                }
                break;
            }
            case "6": {
                let indexDel = parseInt(prompt("введите индекс для удаления "));
                if (!isNaN(indexDel) && indexDel >= 0 && indexDel < task1_9_data.length) {
                    task1_9_data.splice(indexDel, 1);
                } else {
                    alert("неверный индекс");
                }
                break;
            }
            case "7": {
                let indexEdit = parseInt(prompt("введите индекс для изменения "));
                let newValue = prompt("введите новое значени ");
                if (!isNaN(indexEdit) && indexEdit >= 0 && indexEdit < task1_9_data.length) {
                    task1_9_data[indexEdit] = newValue;
                } else {
                    alert("неверный индекс");
                }
                break;
            }
            default:
                alert("неизвестная операция");
        }

        displayTask1_9_data(); // показать после изменения
    }


function task3_1() {
    const a = parseFloat(prompt("введите основание треугольника "));
    const b = parseFloat(prompt("введите высоту треугольника "));
    const area = (a * b) / 2;
    document.getElementById("task3_1_data").textContent = `Площадь треугольника: ${area}`;
}

function task3_2() {
    const a = Math.floor(Math.random() * 51);
    const b = Math.floor(Math.random() * 51);
    const product = a * b;
    document.getElementById("task3_2_data").textContent = `числа ${a} и ${b}, произведение ${product}`;
}

function task3_4() {
    setInterval(() => {
        const now = new Date();
        document.getElementById("task3_4_data").textContent = now.toLocaleTimeString();
    }, 1000);
}

let task3_5_toggled = false;
function task3_5() {
    const img = document.getElementById("task3_5_img");
    if (!task3_5_toggled) {
        img.src = "https://avatars.mds.yandex.net/i?id=2a00000196ff42ca69579907734dba8164f8-1609981-fast-images&n=13";
        img.style.border = "3px solid black";
        img.style.width = "200px";
        task3_5_toggled = true;
    } else {
        img.src = "https://yandex-images.clstorage.net/5dZf5c100/8e1ac4IBY/S9WOOBg6K5ERiEun_Trt2lcwuusftgqnxegD4lIfIllN4tpCXRKzXmilBptl8U-3-hSBW_94R6P1-yLCnZjkJQOY3zUpIzPwbMFXwq0a4c5fRc_nW8ditrGBCpM6UkMwLcLb-8TaO9PQAI4yqUS2j_dgnB7HHUvmQFtnlnDdrSjvSQ5QgCJ6LYEQloe1ghHmD-1KZ7PLYl4xRHr3IlNzocAvEyOQtmdnlOxODjHkmldDSNAymi2TBtye177AlRG8f0E-OMw2arWF2CoHjablQhNtGs9PPw5G4fjKz15To8FoO3cvHOqrYzxo9lbhSIYvd-hAJgZpmyaMskdaVCFV1O8JuiAYzuL9tSyWT3naDaoL3VZnG38O5oEYjt8iKwMNbKevnwRme29kLC6K0QjG87_gQL4yqccmsLanNtgFtbTjRTZYTM7WEY2Moq_RCgUSc20-eydjBiZxyCZLLk8TrRzTqwMYFo9PGGhKnv0ENkN3yMgqlukPKvT2-wIcCYlgc51WvFim0hm1qObfxVp9joPFRpfrSyK-KQDCGyZDA20cizfLmIIT52yo6raVIKarY3jkgqoRC3aoHn9GyElluJOFQvhULrYNPcCaF6VqFfoXmcbvyz8y5n2MlvMaTz-pCFM7p-BSd0fs1O72dcwKxxcMxGqaAbN64JbPWswdjVjvnS40PNK2YXm4HjsFkp3a09U6d6svrjrR7PoTCsuP4UTnoy8UtpdXPIwmKvmIKl-zaBiaRrEvvgTGO9pUffX4Vy1qeAQmQvl9XLpbUXpB2sthjm-DUxrG3cBCo8ar67n0EyMfJE77R2TYbsZtNLbX0xjUkvq5p6Locu9SyFkxYPORPuAs3nqZ_fBOs_n-Sf57nWJ_t-ueUjFIFl--U28BFLdDSxASF4c44G4i4aBSq2sA7G6yvbOumIbj-kDBecDThYJsAHq2Sa3YVkvRdokSE5kKh2sHCsZx9JbzEpu4";
        img.style.border = "none";
        img.style.width = "150px";
        task3_5_toggled = false;
    }
}

const task3_6_cards = [
    { img: "https://via.placeholder.com/100", title: "товар 1", text: "описание товара 1" },
    { img: "https://via.placeholder.com/100", title: "товар 2", text: "описание товара 2" },
    { img: "https://via.placeholder.com/100", title: "товар 3", text: "описание товара 3" }
];
let task3_6_index = 0;

function task3_6() {
    const container = document.getElementById("task3_6_container");
    const cardData = task3_6_cards[task3_6_index % task3_6_cards.length];

    const card = document.createElement("div");
    card.style.border = "1px solid gray";
    card.style.padding = "10px";
    card.style.marginTop = "10px";
    card.style.width = "200px";

    const img = document.createElement("img");
    img.src = cardData.img;
    img.style.width = "100%";

    const title = document.createElement("h3");
    title.textContent = cardData.title;

    const text = document.createElement("p");
    text.textContent = cardData.text;

    card.appendChild(img);
    card.appendChild(title);
    card.appendChild(text);
    container.appendChild(card);

    task3_6_index++;
}

function task3_7() {
    const name = localStorage.getItem("task3_7_name") || prompt("как вас зовут?");
    if (name) {
        localStorage.setItem("task3_7_name", name);
        document.getElementById("task3_7_data").textContent = `Привет, ${name}!`;
    }
}

function task3_8() {
    const questions = [
        { q: "js расшифровывается как?", a: "javascript" },
        { q: "typeof null === ?", a: "object" },
        { q: "cколько типов данных в JS ?", a: "8" },
        { q: "какой метод преобразует JSON в строку?", a: "stringify" },
        { q: "что вернёт 0 == false?", a: "true" }
    ];
    let result = "";
    let score = 0;
    for (let i = 0; i < questions.length; i++) {
        const answer = prompt(questions[i].q);
        const correct = answer?.trim().toLowerCase() === questions[i].a.toLowerCase();
        result += `${i + 1}. ${questions[i].q}<br>Ваш ответ: ${answer || "пусто"} - ${correct ? "верно" : "неверно"}<br><br>`;
        if (correct) score++;
    }
    result = `Вы набрали ${score} из ${questions.length} баллов.<br><br>` + result;
    document.getElementById("task3_8_result").innerHTML = result;
}

task3_4();
task3_7();
