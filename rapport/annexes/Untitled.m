echo off
clear
global k m M g l
g=9.81 ; k=4 ; m=1 ; M=8 ; l=10;
options = odeset('RelTol',1e-10);
[t,theta] = ode45(@simple_pendulum_deriv,[0:0.1:40],[6 0 pi/4 0], options);
[t,theta2] = ode45(@simple_pendulum_deriv,[0:0.1:40],[6.001 0 pi/4 0], options);
fig1=figure('Name','Representation temporelle du mouvement');
fig2=figure('Name','Plan des phases');

figure(fig1);
plot(t,theta(:,1),'-r')
hold on 
plot(t,theta2(:,1),'-b')
axis([0 40 -20 20])
title('Representation temporelle du mouvement');
xlabel('t');
ylabel('x');

figure(fig2);
plot(theta(:,3),theta(:,4),'-r')
hold on
plot(theta2(:,3),theta2(:,4),'-b')
axis equal
title('Plan des phases');
xlabel('\theta');
ylabel('d\theta /dt');