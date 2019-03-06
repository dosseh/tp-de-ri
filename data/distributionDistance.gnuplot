set terminal png 15
set encoding utf8
set output "distributionDistance.png"
set xrange [0:20]
set yrange [0:0.3]
set xlabel "x"

plot "file_distributionDistance" t "Distribution de distance" with linesp lt 1 pt 1

