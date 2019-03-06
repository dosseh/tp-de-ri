
set terminal png 15
set encoding utf8
set output "distributionDegreesBaraAlea.png"
set yrange [1e-6:1]
set logscale xy
set xlabel "x"
plot "file_distributionDegreesAleatoire" t "Distribution de degrees Aleatoire" with linesp lt 1 pt 1,"file_distributionDegreesBarabasiAlbert" t "Distribution de degrees BarabasiAlbert" with linesp lt 2 pt 2
