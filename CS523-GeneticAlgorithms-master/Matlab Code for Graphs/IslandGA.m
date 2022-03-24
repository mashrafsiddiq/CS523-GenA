
%Group T9

%Plot for Island GA

data1 = [1523,1522,1495,1470,1449,1446,1409,1364,1328,1318,1317,1281,1271,1267,1232,1226,1200,1189,1145,1091,1089,891,836,0];

data2 = [1681,1619,1598,1591,1562,1540,1481,1477,1470,1442,1434,1420,1407,1385,1374,1343,1329,1316,1285,1283,1260,1244,1224,1138];

data3 = [1:24];

scatter(data3,data1,'*m');
hold on
scatter(data3,data2,'or');
hold off

set(gca, 'XTickLabelMode', 'Manual')
set(gca, 'XTick', [])

title('Fitness Landscape and Diversity of Warrriors Using Island GA', 'FontSize', 14);
