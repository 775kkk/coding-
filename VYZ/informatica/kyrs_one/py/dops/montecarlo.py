import graphics as gr
import random
import math

def calculate_pi(n):
    window = gr.GraphWin("пи кружок в квадратике(окне)", 550, 550)
    square = gr.Rectangle(gr.Point(0, 0), gr.Point(500, 500))
    circle = gr.Circle(gr.Point(250, 250), 250)
    square.draw(window)
    circle.draw(window)
    pozInKryg = 0
    results = [] 

    for i in range(1, n + 1):
        x = random.randint(0, 500)
        y = random.randint(0, 500)
        point = gr.Circle(gr.Point(x, y), 2)
        point.draw(window)

        if (x - 250)*2 + (y - 250)*2 <= 250*2:
            pozInKryg += 1
            point.setFill('blue')
        else:
            point.setFill('red')

        if i % 100 == 0: 
            onlinePI = 4 * pozInKryg / i
            otnosErorOfPI = abs((math.pi - onlinePI) / math.pi) *100
            results.append((i, otnosErorOfPI))
            print(f"Точек нанесено: {i}, Онлайн число π: {onlinePI}, Относительная ошибка: {otnosErorOfPI:.4f}%")

    with open('result.csv', 'w') as f:
        f.write("поинтов сделано,относ ошибка\n")
        for points, error in results:
            f.write(f"{points},{error}\n")

    window.getMouse()
    window.close()

num_points = 1000
calculate_pi(num_points)

