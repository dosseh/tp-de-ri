set terminal png 15
set encoding utf8
set output "distributionDistanceBaraAlea.png"
set xrange [0:10]
set yrange [0:0.3]
set xlabel "x"

plot "file_distributionDistanceAleatoire" t "Distribution de degrees Aleatoire" with linesp lt 1 pt 1,"file_distributionDistanceBarabasiAlbert" t "Distribution de degrees BarabasiAlbert" with linesp lt 2 pt 2
