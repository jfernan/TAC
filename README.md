# Compilador con CUP, JFlex y Java

Compilador en Java, empleando [CUP](http://www2.cs.tum.edu/projects/cup/) y [JFlex](http://jflex.de/), que traduce de un pequeño lenguaje similar a Java a código de tres direcciones.

## Compilación
### Código fuente 

* Las variables no necesitan instanciación. Todas las variables están definidas y asignadas inicialmente a 0.
* Se admiten expresiones de asignación, aritméticas (suma, resta, multiplicación y división), lógicas (and, or y not) y relacionales (mayor que, menor que, igual, mayor o igual, menor o igual y distinto).
* Se admiten sentencias de control (*if*, *if else*, *while*, *do while* y *for*), la sentencia de asignación y la sentencia *print*.

### Código objeto

Está formado por una secuencia de sentencias de código de tres direcciones, terminadas en punto y coma, que manipulan constantes o variables enteras. Todas las variables están definidas y asignadas inicialmente a 0.

## Ejemplos

El siguiente código fuente 

```
x = 1;
y = 2;
r = s = 3;
sum = x+y+r+s;
print (sum-(r+s)/2);
```

da como resultado el siguiente código en tres direcciones, cuya ejecución imprimiría el valor ```6```: 

```
   x = 1;
   y = 2;
   s = 3;
   r = s;
   t0 = x + y;
   t1 = t0 + r;
   t2 = t1 + s;
   sum = t2;
   t3 = r + s;
   t4 = t3 / 2;
   t5 = sum - t4;
   print t5;
```

El siguiente código fuente 

```
if ( x == 0 ) {
    if (y <= 1) {
		if (z >= x) {
	    	print (-1);
		}
    }
}
print(-2);
```

da como resultado el siguiente código en tres direcciones, cuya ejecución imprimiría los valores ```-1``` y ```-2```:

```
   if (x == 0) goto L0;
   goto L1;
L0:
   if (x < y) goto L4;
   goto L3;
L3:
   if (z < x) goto L7;
   goto L6;
L6:
   t0 = -1;
   print t0;
   goto L8;
L7:
L8:
   goto L5;
L4:
L5:
   goto L2;
L1:
L2:
   t1 = -2;
   print t1;
```

El siguiente código fuente 

```
x = -2;
if (x != -2 || x == -2) {
	if (y == x) {
		z = 1;
	} else {
		z = 2;
	}
}
print (z);
```

da como resultado el siguiente código en tres direcciones, cuya ejecución imprimiría el valor ```2```:

```
   t0 = -2;
   x = t0;
   t1 = -2;
   if (x == t1) goto L1;
   goto L0;
L1:
   t2 = -2;
   if (x == t2) goto L2;
   goto L3;
L0:
   goto L2;
L2:
   if (y == x) goto L5;
   goto L6;
L5:
   z = 1;
   goto L7;
L6:
   z = 2;
L7:
   goto L4;
L3:
L4:
   print z;
```

El siguiente código fuente 

```
fibonacci = 1;
previous = 1;
for (i=1; i<10; i=i+1) {
	temp = fibonacci;
	fibonacci = fibonacci + previous;
	previous = temp;
	
}    
print(fibonacci);
```

da como resultado el siguiente código en tres direcciones, cuya ejecución imprimiría el valor ```89```:

```
   fibonacci = 1;
   previous = 1;
   i = 1;
L0:
   if (i < 10) goto L1;
   goto L2;
L3:
   t0 = i + 1;
   i = t0;
   goto L0;
L1:
   temp = fibonacci;
   t1 = fibonacci + previous;
   fibonacci = t1;
   previous = temp;
   goto L3;
L2:
   print fibonacci;
```

