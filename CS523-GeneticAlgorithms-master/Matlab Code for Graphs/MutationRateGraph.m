
%Group T9

%Plots for Varying Mutation Rate


%0.2
data1 = [1054,1163,1197,1170,1198,1317,1343,1351,1460,1389,1362,1478,1446,1516,1616,1530,1557,1649,1645,1612];

%0.5
data2 = [1165,1230,1225,1309,1340,1430,1563,1489,1535,1499,1445,1583,1541,1468,1442,1539,1526,1515,1592,1582];

%0.8
data3 = [1406,1278,1573,1375,1409,1462,1482,1472,1520,1567,1539,1573,1540,1536,1472,1505,1518,1562,1515,1570];

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

