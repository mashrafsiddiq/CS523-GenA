
%Group T9

%Plots for Varying Crossover


%Uniform
data1 = [1459,1341,1413,1428,1504,1584,1532,1524,1606,1559,1557,1564,1555,1515,1636,1593,1543,1588,1600,1572];

%OnePoint
data2 = [1165,1230,1225,1309,1340,1430,1563,1489,1535,1499,1445,1583,1541,1468,1442,1539,1526,1515,1592,1582];

%No Crossover
data3 = [1203,1227,1281,1409,1298,1387,1393,1469,1435,1482,1509,1497,1500,1474,1513,1654,1516,1533,1554,1590];

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
boxplot([data1',data2',data3'], 'Notch', 'off', 'Labels', {'Uniform','OnePoint','No Crossover'});

p = ranksum(data1, data2);
x = ranksum(data2, data3);
y = ranksum(data1, data2);

