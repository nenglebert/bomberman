clear all; close all;
it = 20;
fig1=figure('Name','Section de Poincare');
box on;
hold on
global k m M g l
g=9.81 ; k=4 ; l=10 ; m=1 ; M = 1.5;
options = odeset('RelTol',1e-10);
box on;grid on;
[t,theta] = ode45('simple_pendulum_deriv',[10:0.01:600],[6 0 pi/4 0],options);
[t,theta2] = ode45('simple_pendulum_deriv',[10:0.01:600],[6.001 0 pi/4 0],options);
plot(wrapToPi(theta([10:it:end],3)),theta([10:it:end],4),'.','Color','r','Markersize',4)
plot(wrapToPi(theta2([10:it:end],3)),theta2([10:it:end],4),'.','Color','b','Markersize',4)
figure(fig1);
title('Section de Poincare')
xlabel('\theta')
ylabel('d\theta/dt')
axis equal