function dy = simple_pendulum_deriv(t,x)
global k m M g l
dy=zeros(4,1);
mu=m/(m+M);Kappa=k/(m+M);

dy(1) = x(2);
dy(2) = (mu*l*x(4)*x(4)*sin(x(3))+mu*g*sin(x(3))*cos(x(3))-Kappa*x(1))/(1-mu*cos(x(3))*cos(x(3)));
dy(3) = x(4);
dy(4) = (-mu*x(4)*x(4)*sin(x(3))*cos(x(3))+Kappa/l*x(1)*cos(x(3))-g/l*sin(x(3)))/(1-mu*cos(x(3))*cos(x(3)));