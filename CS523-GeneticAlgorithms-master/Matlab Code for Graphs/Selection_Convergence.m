
%Group T9

%Plots for Varying Selection


%Random
data1 = [1165,1230,1225,1309,1340,1430,1563,1489,1535,1499,1445,1583,1541,1468,1442,1539,1526,1515,1592,1582];

%Roulette
data2 = [1087,1425,1391,1389,1354,1406,1422,1442,1433,1383,1441,1470,1422,1418,1473,1441,1385,1508,1395,1379];

%Tournament
data3 = [1300,1474,1502,1504,1486,1534,1514,1629,1501,1516,1552,1608,1581,1577,1615,1557,1559,1568,1611,1640];

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
boxplot([data1',data2',data3'], 'Notch', 'off', 'Labels', {'Random','Roulette','Tournament'});

p = ranksum(data1, data2);
x = ranksum(data2, data3);
y = ranksum(data1, data2);

