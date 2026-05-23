# 🎉 Nuevas Funcionalidades - Tech-Park UQ

## ✨ Mejoras Implementadas

### 1. 🔐 Sistema de Registro Completo

#### Registro para Todos los Roles
Ahora puedes registrarte como:
- **Visitante**
- **Operador**
- **Administrador**

#### Cómo Registrarse:

1. **Selecciona tu rol** en el ComboBox de la pantalla de login
2. **Haz clic en "Registrarse"**
3. **Completa el formulario** según el rol:

**Visitante:**
- Nombre
- Cédula
- Edad
- Estatura (en metros)

**Operador:**
- Nombre
- Cédula
- Edad
- ID Empleado
- Zona Asignada (seleccionar del ComboBox)

**Administrador:**
- Nombre
- Cédula
- Edad
- ID Empleado
- Sueldo

---

### 2. 🎯 Sistema de Puntos

#### ¿Cómo Funciona?

**Obtener Puntos:**
- Compra tickets para obtener puntos
- Ticket General: **+100 puntos**
- Ticket Familiar: **+400 puntos**
- Fast-Pass: **+200 puntos**

**Usar Puntos:**
- Cada atracción tiene un costo en puntos
- Usa tus puntos para acceder a atracciones sin gastar dinero adicional

#### Costos por Tipo de Atracción:

| Tipo de Atracción | Costo en Puntos |
|-------------------|-----------------|
| MECANICA_ALTURA | 50 puntos |
| ACUATICA | 30 puntos |
| INFANTIL | 20 puntos |
| OTRO | 25 puntos |

#### Ejemplo de Uso:

```
1. Compras un Ticket General ($50,000)
   → Obtienes 100 puntos

2. Vas a "Mapa y Atracciones"
   → Seleccionas "Montaña Rusa" (50 puntos)
   → Haces clic en "Usar Puntos"
   → Acceso concedido!
   → Te quedan 50 puntos

3. Seleccionas "Tobogán Acuático" (30 puntos)
   → Haces clic en "Usar Puntos"
   → Acceso concedido!
   → Te quedan 20 puntos
```

---

### 3. ⭐ Sistema de Favoritos

#### Funcionalidades:

**Agregar a Favoritos:**
1. Ve a "Mapa y Atracciones"
2. Haz clic en "Favorito" en la atracción deseada
3. La atracción se agrega a tu lista de favoritos

**Ver Favoritos:**
1. Ve a la pestaña "Mis Favoritos"
2. Verás todas tus atracciones favoritas
3. Puedes ver su estado en tiempo real

**Eliminar de Favoritos:**
1. En la pestaña "Mis Favoritos"
2. Haz clic en "Eliminar" en la atracción
3. Se elimina de tu lista

**Beneficios:**
- Acceso rápido a tus atracciones preferidas
- Notificaciones cuando cambien de estado
- Seguimiento de disponibilidad

---

### 4. 💰 Compra de Tickets Mejorada

#### Nuevas Características:

**Sistema de Puntos Integrado:**
- Cada compra te otorga puntos
- Los puntos se muestran en tiempo real
- Puedes ver tus puntos en:
  - Pestaña "Mi Perfil"
  - Pestaña "Tienda de Tickets"
  - Pestaña "Mapa y Atracciones"

**Información Detallada:**
Cada ticket muestra:
- Precio en dinero
- Puntos que obtendrás
- Beneficios incluidos

---

## 🎮 Guía de Uso Completa

### Escenario 1: Nuevo Visitante

```
1. Pantalla de Login
   → Selecciona "Visitante"
   → Clic en "Registrarse"
   → Completa formulario
   → Clic en "OK"

2. Inicia Sesión
   → Ingresa tu cédula
   → Selecciona "Visitante"
   → Clic en "Ingresar"

3. Recarga Saldo
   → Ve a "Mi Perfil"
   → Clic en "Recargar Saldo"
   → Ingresa monto (ej: 100000)
   → Confirma

4. Compra Ticket
   → Ve a "Tienda de Tickets"
   → Clic en "Comprar" (Ticket General)
   → Obtienes 100 puntos

5. Agrega Favoritos
   → Ve a "Mapa y Atracciones"
   → Clic en "Favorito" en 2-3 atracciones

6. Usa Puntos
   → En "Mapa y Atracciones"
   → Clic en "Usar Puntos" en una atracción
   → Acceso concedido!

7. Revisa Favoritos
   → Ve a "Mis Favoritos"
   → Verás tus atracciones guardadas
```

### Escenario 2: Nuevo Operador

```
1. Registro
   → Selecciona "Operador"
   → Clic en "Registrarse"
   → Completa formulario
   → Selecciona zona (ej: "Zona Acuatica")
   → Confirma

2. Inicia Sesión
   → Ingresa tu cédula
   → Selecciona "Operador"
   → Clic en "Ingresar"

3. Dashboard
   → Verás tu zona asignada en el header
   → Gestiona accesos y mantenimiento
```

### Escenario 3: Nuevo Administrador

```
1. Registro
   → Selecciona "Administrador"
   → Clic en "Registrarse"
   → Completa formulario
   → Ingresa sueldo
   → Confirma

2. Inicia Sesión
   → Ingresa tu cédula
   → Selecciona "Administrador"
   → Clic en "Ingresar"

3. Dashboard
   → Gestiona personal, atracciones, clima y reportes
```

---

## 📊 Tabla de Puntos

### Obtención de Puntos

| Acción | Puntos Obtenidos |
|--------|------------------|
| Comprar Ticket General | +100 |
| Comprar Ticket Familiar | +400 |
| Comprar Fast-Pass | +200 |

### Uso de Puntos

| Atracción | Costo |
|-----------|-------|
| Montaña Rusa Extrema (MECANICA_ALTURA) | 50 puntos |
| Tobogán Acuático (ACUATICA) | 30 puntos |
| Carrusel Mágico (INFANTIL) | 20 puntos |
| Rueda de la Fortuna (MECANICA_ALTURA) | 50 puntos |
| Piscina de Olas (ACUATICA) | 30 puntos |

---

## 🎯 Estrategias de Puntos

### Estrategia 1: Maximizar Puntos
```
1. Compra Ticket Familiar ($150,000)
   → +400 puntos
   
2. Puedes acceder a:
   - 8 atracciones MECANICA_ALTURA (50 pts c/u)
   - 13 atracciones ACUATICA (30 pts c/u)
   - 20 atracciones INFANTIL (20 pts c/u)
```

### Estrategia 2: Equilibrada
```
1. Compra Ticket General ($50,000)
   → +100 puntos
   
2. Compra Fast-Pass ($80,000)
   → +200 puntos
   
Total: 300 puntos
- 6 atracciones MECANICA_ALTURA
- 10 atracciones ACUATICA
- 15 atracciones INFANTIL
```

---

## 🔔 Notificaciones

### Recibirás notificaciones sobre:
- ✅ Cambios de estado en tus favoritos
- ✅ Alertas climáticas
- ✅ Mantenimiento de atracciones
- ✅ Shows y eventos especiales

---

## 💡 Consejos Pro

1. **Compra Ticket Familiar** si vienes en grupo → Más puntos
2. **Agrega favoritos** para seguimiento rápido
3. **Usa puntos estratégicamente** en atracciones caras
4. **Recarga saldo** antes de llegar al parque
5. **Revisa "Mis Favoritos"** para ver disponibilidad

---

## 🆕 Cambios Técnicos

### Modelo Visitante
```java
- int puntosTicket
- List<Atraccion> favoritos
+ agregarPuntos(int puntos)
+ usarPuntosParaAtraccion(int costo)
+ eliminarAtraccionFavorita(Atraccion)
```

### Modelo Atraccion
```java
- int costoEnPuntos
+ getCostoEnPuntos()
```

### LoginController
```java
+ registrarNuevoOperador(...)
+ registrarNuevoAdministrador(...)
```

### VisitanteController
```java
+ agregarAtraccionFavorita(Atraccion)
+ eliminarAtraccionFavorita(Atraccion)
+ usarPuntosParaAtraccion(Atraccion)
+ getAtraccionesFavoritas()
```

---

## ✅ Checklist de Funcionalidades

### Sistema de Registro
- [x] Registro de Visitantes
- [x] Registro de Operadores
- [x] Registro de Administradores
- [x] Validación de duplicados

### Sistema de Puntos
- [x] Obtención de puntos por compra
- [x] Uso de puntos en atracciones
- [x] Visualización de puntos en tiempo real
- [x] Costos diferenciados por tipo

### Sistema de Favoritos
- [x] Agregar a favoritos
- [x] Eliminar de favoritos
- [x] Pestaña dedicada de favoritos
- [x] Prevención de duplicados

### Compra de Tickets
- [x] Ticket General con puntos
- [x] Ticket Familiar con puntos
- [x] Fast-Pass con puntos
- [x] Actualización de saldo y puntos

---

## 🚀 Próximas Mejoras Sugeridas

- [ ] Sistema de logros por puntos acumulados
- [ ] Descuentos por uso de puntos
- [ ] Historial de uso de puntos
- [ ] Compartir favoritos con amigos
- [ ] Ranking de atracciones más populares

---

**¡Disfruta de las nuevas funcionalidades de Tech-Park UQ!** 🎢🎡🎠
