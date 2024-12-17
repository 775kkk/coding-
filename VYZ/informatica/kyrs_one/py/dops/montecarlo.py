import graphics as gr
import random
import math

def calculate_pi(n):
    window = gr.GraphWin("Monte Carlo", 500, 500)
    square = gr.Rectangle(gr.Point(0, 0), gr.Point(500, 500))
    square.draw(window)
    circle = gr.Circle(gr.Point(250, 250), 250)
    circle.draw(window)
    points_inside_circle = 0
    results = [] 

    for i in range(1, n + 1):
        x = random.randint(0, 500)
        y = random.randint(0, 500)
        point = gr.Circle(gr.Point(x, y), 2)
        point.draw(window)

        if (x - 250)*2 + (y - 250)*2 <= 250*2:
            points_inside_circle += 1
            point.setFill('blue')
        else:
            point.setFill('red')

        if i % 100 == 0: 
            pi_approx = 4 * points_inside_circle / i
            relative_error = abs((math.pi - pi_approx) / math.pi) *100
            results.append((i, relative_error))
            print(f"Points: {i}, Approximation of π: {pi_approx}, Relative Error: {relative_error:.4f}%")


    with open('result.csv', 'w') as f:
        f.write("Points,Relative Error\n")
        for points, error in results:
            f.write(f"{points},{error}\n")

    window.getMouse()
    window.close()

num_points = 1000
calculate_pi(num_points)

