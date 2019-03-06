set terminal png 15
set encoding utf8
set output "histogramme_des3cas.png"
set xrange [0:90]
set yrange [0:317080]
set xlabel "Jours"

plot "cas1" t "cas 1" with linesp lt 1 pt 1,"cas2" t "cas 2" with linesp lt 2 pt 2,"cas3" t "cas 3" with linesp lt 3 pt 3