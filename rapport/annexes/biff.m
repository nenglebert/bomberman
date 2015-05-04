clear all;close all
fig1=figure('Name','Diagrammes de bifurcation','visible','off');
options = odeset('RelTol',1e-4);
ylab = 4;
global k m g l M 
g=9.81 ; k=4 ;l=10 ; m=1 ;
for M=0.01:0.1:10
    varc = M;
    for i=0:0.001:0.002
        clear y
        [t,y] = ode45('simple_pendulum_deriv',[0:1:50],[i+6 0 pi/4 0],options);
        if i==0
            plot(varc,y(30:50,4),'rs','Markersize',1);
            hold on
        elseif i==0.001
            plot(varc,y(30:50,4),'bs','Markersize',1);
        else
            plot(varc,y(30:50,4),'gs','Markersize',1);
        end
    end
end
set(fig1,'visible','on')
figure(fig1);
axis([0 10 -ylab ylab])
title('Diagramme de bifurcation');
xlabel('M');
ylabel('d\theta/dt');