# FastMekan
![Image of Yaktocat](img/mechanic.png)

Sistema para gerenciamento de uma oficina mecânica

O sistema proposto pela a equipe será de uma oficina de carros, motos e caminhões, em que ele terá como funções iniciais os seguintes pontos:

* Cadastrar funcionários
* Cadastrar serviços praticados pela a oficina 
* Cadastrar clientes
* Agendar serviços
* Enviar para o cliente por meio de e-mail a confirmação da conclusão do serviço
* Enviar para o cliente por meio de e-mail o orçamento do serviço


Configuração de Ambiente
**Criação do Banco de Dados**

* Instale o PostgreSQL https://www.postgresql.org/download/
* Siga as instruções do intalador
* Usando o programa pgAdmin crie um banco de dados com o seguinte nome "FastMekan"(sem as aspas).

**Configurando bibliotecas no Eclipse

* Baixe a biblioteca SWT no site http://download.eclipse.org/eclipse/downloads/drops4/R-4.7-201706120950/
* Siga para a seção onde está escrito "SWT Binary and Source"
* Baixe o arquivo swt-4.7**** conforme seu sistema operacional(ex:swt-4.7-win32-win32-x86.zip)
* Baixe o driver sql no site https://jdbc.postgresql.org/download.html
* configure o projeto no eclipse, em propriedades>java build path>biblioteca>add external jars
* adicione os jar's baixado anteriomente(do swt e postgresql).


