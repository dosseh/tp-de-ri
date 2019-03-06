
# set terminal png 15
# set encoding utf8
# set output "distributionDegreesLineaire.png"
# set xrange [0:345]
# set yrange [0:0.189]
# set xlabel "x"
# plot "file_distributionDegrees" t "Distribution de degrees" with linesp lt 1 pt 1


set terminal png 15
set encoding utf8  
set output "distributionDegreesLogLog.png"
set yrange [1e-6:1]
set logscale xy
set xlabel "x"  
plot "file_distributionDegrees" t "Distribution de degrees" with linesp lt 1 pt 1


