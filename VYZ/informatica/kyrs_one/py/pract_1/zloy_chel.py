# подключение библиотеки под псевдонимом gr
import graphics as gr

# # Инициализация окна с названием "Окно для рисования" и размером 100х100 пикселей
window = gr.GraphWin("Окно для рисования ", 1000, 1000)

# # Создание круга с радиусом 10 и координатами центра (50, 50)
# my_circle = gr.Circle(gr.Point(50, 50), 10)

# # Создание отрезка с концами в точках (2, 4) и (4, 8)
# my_line = gr.Line(gr.Point(2, 4), gr.Point(4, 8))

# # Создание прямоугольника у которого диагональ — отрезок с концами в точках (2, 4) и (4, 8)
# my_rectangle = gr.Rectangle(gr.Point(2, 4), gr.Point(4, 8))

# # Отрисовка примитивов в окне window
# my_circle.draw(window)
# my_line.draw(window)
# my_rectangle.draw(window)



face = gr.Circle(gr.Point(200, 200), 100)
face.setFill('yellow')

eye1 = gr.Circle(gr.Point(150, 180), 20)
eye2 = gr.Circle(gr.Point(250, 180), 15)
eye1_center = gr.Circle(gr.Point(150, 180), 8)
eye2_center = gr.Circle(gr.Point(250, 180), 7)
eye1.setFill('red')
eye2.setFill('red')
eye1_center.setFill('black')
eye2_center.setFill('black')

eyebrow1 = gr.Line(gr.Point(100, 120), gr.Point(180, 170))
eyebrow2 = gr.Line(gr.Point(220, 170), gr.Point(300, 140))
eyebrow1.setWidth(10)
eyebrow2.setWidth(10)
eyebrow1.setOutline('black')
eyebrow2.setOutline('black')

mouth = gr.Line(gr.Point(150, 260), gr.Point(250, 260))
mouth.setWidth(20)
mouth.setOutline('black')

face.draw(window)
eye1.draw(window)
eye2.draw(window)
eye1_center.draw(window)
eye2_center.draw(window)
eyebrow1.draw(window)
eyebrow2.draw(window)
mouth.draw(window)


#  Ожидание нажатия кнопки мыши по окну.
window.getMouse()

# Закрытие окна после завершения работы с графикой
window.close()


