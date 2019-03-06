set terminal png
set xlabel 'k'
set ylabel 'p(k)'
set output "all_in_one.png"

set logscale xy
set yrange [1e-6:1]

# POISSON

lambda = 6.622
poisson(x) = lambda ** x * exp(-lambda)/gamma(x+1)

f(x) = lc - gamma * x
fit f(x) 'all_in_one' using (log($1)):(log($2)) via lc, gamma

# lc    = 2.34298       +/- 0.1971      (8.414%)
# gamma = 2.70556       +/- 0.04438     (1.64%)

c = exp(lc)

power (x) = c * x ** (-gamma)

plot 'all_in_one' title 'DBLP', \
    poisson(x) title 'distribution de Poisson', \
    power(x) title 'Coeficient de la loi de puissance'