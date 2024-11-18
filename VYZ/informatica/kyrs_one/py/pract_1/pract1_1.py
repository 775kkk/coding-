import graphics as gr

# ///////////--------->

row = 500#ширина
col = 500#высота

centerCOL = col/2
centerROW = row/2


window = gr.GraphWin("Окно для рисования ",row, col) # шир выс

fon1 = gr.Rectangle(gr.Point(0, centerROW), gr.Point(row, col))

# ///////////---------

fon1.draw(window)
fon1.setFill("red")

# ///////////---------
window.getMouse()
window.close()
