# TeamApp - Ejercicio de GitHub con Android y Compose

## Objetivo
Este ejercicio tiene como objetivo practicar **colaboración con Git y GitHub** dentro de un proyecto Android nativo con **Kotlin y Jetpack Compose**.  
Los estudiantes trabajarán en equipo, utilizando ramas, commits, Pull Requests y revisiones de código, simulando un flujo de trabajo real.

## Funciones Implementadas

### Funciones Base
- **TeamMember data class**: Modelo de datos para miembros del equipo
- **FakeTeamRepository**: Repositorio que devuelve lista de miembros del equipo
- **TeamListScreen**: Pantalla principal con lista de miembros usando LazyColumn
- **Material Design 3**: Diseño moderno con estilo Frutiger Aero

### Funciones Opcionales
- **TeamDetailScreen**: Pantalla de detalle de cada miembro
- **Navigation**: Sistema de navegación entre pantallas
- **Avatares personalizados**: Imagen hamsti.jpeg para todos los miembros
- **Diseño Frutiger Aero**: Estética limpia y moderna con fondo personalizado

## Arquitectura del Proyecto

```
app/src/main/java/com/uvg/teamapp/
├── model/
│   └── TeamMember.kt
├── data/repository/
│   └── FakeTeamRepository.kt
├── ui/
│   ├── navigation/
│   │   └── AppNavigation.kt
│   ├── screens/
│   │   ├── TeamListScreen.kt
│   │   └── TeamDetailScreen.kt
│   └── theme/
└── MainActivity.kt
```

## Capturas de Pantalla

### Pantalla Principal - Lista de Equipo
- Lista de miembros del equipo con LazyColumn
- Diseño Frutiger Aero con fondo personalizado
- Cards semitransparentes con información de miembros
- Avatares para cada miembro

<img width="1080" height="2400" alt="image" src="https://github.com/user-attachments/assets/853beba3-1607-4c2d-bb2a-a4eff3d0eb2e" />


### Pantalla de Detalle
- Información detallada de cada miembro
- Avatar grande con imagen
- Navegación de regreso a la lista
- Diseño consistente con la pantalla principal

<img width="1080" height="2400" alt="image" src="https://github.com/user-attachments/assets/f6c0bb06-94b9-495e-9827-de3ac00019df" />


## Flujo de Trabajo con Git

### Ramas Utilizadas
- `main`: Rama principal del proyecto
- `develop`: Rama de integración
- `feature/fatima-repository-and-list`: Implementación de funciones base
- `feature/fatima-navigation-detail`: Implementación de funciones opcionales

### Pull Requests Creados
1. **PR Base**: FakeTeamRepository y TeamListScreen
   - Implementación de las tareas asignadas (Integrante 2 y 3)
   - Siguió principios de Clean Code
   - Revisión y aprobación del equipo

2. **PR Opcional**: TeamDetailScreen y navegación
   - Funciones opcionales completadas
   - Sistema de navegación implementado
   - Diseño Frutiger Aero consistente

## Tecnologías Utilizadas
- **Kotlin**: Lenguaje de programación principal
- **Jetpack Compose**: Framework de UI moderna
- **Navigation Compose**: Navegación entre pantallas
- **Material Design 3**: Sistema de diseño
- **Clean Architecture**: Principios de código limpio
- **Git Flow**: Metodología de control de versiones

## Roles del Equipo
- **Adrian**: Crear TeamMember data class
- **Fatima**: Crear FakeTeamRepository (Integrante 2) y TeamListScreen (Integrante 3)
- **Integrantes adicionales (no hay)**: TeamDetailScreen y funciones opcionales

## Lecciones Aprendidas

### Trabajo en Equipo
- Importancia de la comunicación clara en PRs
- Coordinación efectiva usando ramas de feature
- Revisiones de código constructivas

### Desarrollo Técnico
- Implementación de Clean Architecture en Android
- Uso efectivo de Jetpack Compose para UI moderna
- Integración de sistema de navegación limpio y escalable

### Git Flow
- Manejo profesional de ramas y merges
- Commits descriptivos siguiendo convenciones
- Resolución collaborative de conflictos

## Estado del Proyecto
- Todas las funciones base implementadas
- Funciones opcionales completadas
- Navegación funcional entre pantallas
- Diseño Frutiger Aero implementado
- Clean Code principles aplicados
- Pull Requests revisados y mergeados
- Documentación completa

## Cómo Ejecutar el Proyecto
1. Clonar el repositorio
2. Abrir en Android Studio
3. Sync del proyecto con Gradle
4. Ejecutar en emulador o dispositivo Android

El proyecto está listo para uso y demuestra un flujo de trabajo profesional con Git, GitHub y desarrollo Android moderno.
