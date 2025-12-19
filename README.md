# Synthesizer Remastered 🎹

Aplicação desktop de síntese sonora desenvolvida em **Java**, utilizando **Swing** para a interface gráfica e **OpenAL (LWJGL)** para geração e reprodução de áudio em tempo real.

O projeto simula um **sintetizador polifônico** com múltiplos osciladores, diferentes formas de onda e controles interativos de tom e volume, além de um visualizador gráfico da onda sonora.

---

## 📝 Descrição

O **Synthesizer Remastered** é um sintetizador virtual simples, porém completo, focado em estudo e experimentação de conceitos de áudio digital. A aplicação permite tocar notas via teclado, misturar múltiplos osciladores e visualizar a forma de onda resultante em tempo real.

O código foi estruturado de forma modular, separando responsabilidades entre áudio, interface gráfica, visualização e utilidades matemáticas, tornando o projeto fácil de entender, manter e evoluir.

---

## 🚀 Principais Funcionalidades

* 🎼 Geração de áudio em tempo real
* 🎹 Controle via teclado do computador
* 🔊 Múltiplos osciladores simultâneos
* 🌊 Formas de onda: Sine, Square, Saw e Triangle
* 🎚️ Controle de volume e ajuste fino de tom
* 📈 Visualização gráfica da onda sonora
* 🧩 Arquitetura modular e organizada

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java
* **Interface Gráfica:** Swing (JFrame, JPanel, etc.)
* **Áudio:** OpenAL (via LWJGL)
* **Renderização Gráfica:** Java AWT / Graphics2D
* **Paradigmas:** Programação Orientada a Objetos

---

## 🧱 Organização do Projeto e Responsabilidades

O projeto segue uma organização baseada em responsabilidades bem definidas:

```
com.synth
├── Main.java                     # Ponto de entrada da aplicação
├── SynthesizerRemastered.java    # Janela principal e controle geral
├── AudioThread.java              # Thread responsável pela geração de áudio
├── Oscillator.java               # Oscilador individual
├── Wavetable.java                # Formas de onda pré-calculadas
├── WaveViewer.java               # Visualizador da onda sonora
├── SynthControlContainer.java    # Componente base para controles
├── OpenALException.java          # Exceções relacionadas ao OpenAL
└── utils
    ├── Utils.java                # Funções utilitárias e matemáticas
    ├── Procedure.java            # Interface funcional
    └── RefWrapper.java           # Wrapper de referência mutável
```

### Principais Componentes

* **AudioThread**: Gerencia buffers OpenAL e realiza a síntese sonora contínua.
* **Oscillator**: Gera amostras de áudio baseadas em wavetable, frequência e volume.
* **WaveViewer**: Renderiza graficamente a forma de onda combinada dos osciladores.
* **Utils**: Concentra cálculos matemáticos, manipulação de parâmetros e estilos visuais.

---

## ⌨️ Controles

* **Teclado do computador**: toca notas musicais mapeadas em diferentes teclas
* **Mouse**:

  * Arrastar parâmetros para alterar volume e tom
  * Selecionar forma de onda por oscilador

---

## ▶️ Como Executar o Projeto

### Pré-requisitos

* Java JDK 17 ou superior
* [LWJGL](https://www.lwjgl.org/customize) baixado e configurado com suporte a OpenAL

### Execução

1. Clone o repositório:

```bash
git clone git@github.com:TrisKeliOn1/Audio-Synthesizer-.git
```

2. Abra o projeto em sua IDE (IntelliJ IDEA recomendado)

3. Configure as dependências do LWJGL

4. Execute a classe `Main`:

```java
public static void main(String[] args) {
    new SynthesizerRemastered();
}
```

A aplicação será aberta em uma janela desktop.

---

## 🎯 Objetivo do Projeto

Este projeto tem como objetivo principal:

* Estudar síntese sonora digital
* Explorar áudio em tempo real com Java

---

##
