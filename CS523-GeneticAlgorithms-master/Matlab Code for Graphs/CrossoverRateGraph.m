
%Group T9

%Plots for Varying Crossover Rate


%0.2
data1 = [802,798,869,778,828,922,1140,1117,1218,1307,1244,1290,1420,1347,1344,1300,1299,1434,1342,1429];

%0.5
data2 = [1165,1230,1225,1309,1340,1430,1563,1489,1535,1499,1445,1583,1541,1468,1442,1539,1526,1515,1592,1582];

%0.8
data3 = [1337,1368,1394,1490,1541,1636,1629,1649,1629,1617,1570,1643,1569,1636,1701,1637,1671,1702,1782,1820];

%generation
data4 = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20];

h1=figure;
plot(data4,data1,'-om');

hold on
plot(data4,data2,'--b');
hold off

hold on
plot(data4, data3, '-*r');
hold off


h2=figure;
boxplot([data1',data2',data3'], 'Notch', 'off', 'Labels', {'0.2','0.5','0.8'});

p = ranksum(data1, data2);
x = ranksum(data2, data3);
y = ranksum(data1, data2);

