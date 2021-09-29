package programas;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classes.*;

public class Programa{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int opcao = 0;
    List <Produto> produtos = new ArrayList<>();
    List <Venda> vendas = new ArrayList<>();
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("0 - Sair");
            System.out.println("1 - Incluir produto");
            System.out.println("2 - Consultar produto");
            System.out.println("3 - Listagem de produtos");
            System.out.println("4 - Vendas por período – detalhado");
            System.out.println("5 – Realizar venda");
            System.out.print("Opção: ");
      
            opcao = sc.nextInt();
            sc.nextLine(); 
      
            switch (opcao) {
              case 0:
              System.out.println("Fim do programa!");
              break;
              case 1: 

              System.out.print("Nome: ");
              String nomeprod = sc.nextLine();
            
              System.out.print("Código: ");
              String cod = sc.nextLine();
             
              System.out.print("Valor: ");
              Double val = sc.nextDouble();
              
              System.out.print("Quantidade: ");
              int qtd = sc.nextInt();
              sc.nextLine();
            
              Produto produto = new Produto();
              produto.setNome(nomeprod);
              produto.setCodigo(cod);
              produto.setValor(val);
              produto.setQuantidadeEstoque(qtd);
              produtos.add(produto);
              
              break;
              case 2: 
              
              if (produtos.isEmpty())
              System.out.println("Nenhum produto foi registrado.");
              else  
              System.out.println("Digite o código do produto"); 
              String codDigitado = sc.nextLine();
              for (Produto p : produtos)
              if (codDigitado.equals(p.getCodigo()))
               System.out.printf("Nome: %s Código: %s Valor: %s Quantidade: %s\n", p.getNome(), p.getCodigo(), p.getValor(), p.getQuantidadeEstoque());
              
              
              break;
              case 3: 
              if (produtos.isEmpty())
              System.out.print("Nenhum produto foi registrado.");
              else System.out.print("Produtos: ");
              for (Produto p : produtos)
              System.out.printf("Nome: %s Código: %s Valor: %s Quantidade: %s\n", p.getNome(), p.getCodigo(), p.getValor(), p.getQuantidadeEstoque());
              
           

              break;
              case 4: if (vendas.isEmpty())
              System.out.print("Nenhuma venda foi cadastrada.");
              else try{ 

                  System.out.println("Digite uma data [DD/MM/AAAA]");
                  String dataRecebida = sc.nextLine();
                  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                  String date = dataRecebida;
                  LocalDate localDate = LocalDate.parse(date, formatter);
                  for (Venda v : vendas)
                  System.out.printf(" Nome: %s Quantidade: %s Valor da venda: %s Data da venda: ", v.getProdutoVendido(), v.getQuantidadeVendida(), v.getValorVenda());
                  System.out.println(formatter.format(localDate));
              } catch (Exception ex) {
                  ex.printStackTrace();
              } 
              break;
              case 5:
              System.out.println("Digite o código do produto");
              String codDigitado2 = sc.nextLine();
              for (Produto p : produtos)
              if (codDigitado2.equals(p.getCodigo()))
              System.out.printf("Nome: %s Código: %s Valor: %s Quantidade: %s\n", p.getNome(), p.getCodigo(), p.getValor(), p.getQuantidadeEstoque());
              System.out.println("Digite a quantidade sendo comprada");
              int qtdVendida = sc.nextInt();
              sc.nextLine();
              System.out.print("Valor total: ");
              for (Produto p : produtos)
              System.out.print(p.getValor() * qtdVendida);
              Venda venda = new Venda();
              venda.setQuantidadeVendida(qtdVendida);
              for (Produto p : produtos)
              venda.setProdutoVendido(p.getNome());
              for (Produto p : produtos)
              venda.setValorVenda(p.getValor() * qtdVendida);
              vendas.add(venda);
              
              
              
              break;
    }
}while (opcao != 0);

sc.close();
}
}

