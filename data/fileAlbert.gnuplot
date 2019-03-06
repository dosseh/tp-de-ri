set terminal png 15
set encoding utf8
set output "histogramme_des3casAlbert.png"
set xrange [0:90]
set yrange [0:317080]
set xlabel "Jours"

plot "cas1Albert" t "cas 1" with linesp lt 1 pt 1,"cas2Albert" t "cas 2" with linesp lt 2 pt 2,"cas3Albert" t "cas 3" with linesp lt 3 pt 3