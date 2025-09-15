import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {

        // 3.1 - Inserir todos os funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
        
        System.out.println("--- 3.1 - Funcionários Inseridos ---");
        imprimirFuncionarios(funcionarios);
        System.out.println();

        // 3.2 - Remover o funcionário "João"
        funcionarios.removeIf(f -> f.getNome().equals("João"));
        
        System.out.println("--- 3.2 - Remoção de 'João' Concluída ---");
        System.out.println();
        
        // 3.3 - Imprimir todos os funcionários (com "João" removido)
        System.out.println("--- 3.3 - Lista de Funcionários Atualizada ---");
        imprimirFuncionarios(funcionarios);
        System.out.println();

        // 3.4 - Aumento de 10%
        BigDecimal aumento = new BigDecimal("1.10");
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(aumento)));
        
        System.out.println("--- 3.4 - Salários Aumentados em 10% ---");
        imprimirFuncionarios(funcionarios);
        System.out.println();

        // 3.5 - Agrupar os funcionários por função
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
        
        System.out.println("--- 3.5 - Agrupamento por Função Concluído ---");
        System.out.println();

        // 3.6 - Imprimir os funcionários agrupados por função
        System.out.println("--- 3.6 - Funcionários Agrupados por Função ---");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("-> Função: " + funcao);
            imprimirFuncionarios(lista);
        });
        System.out.println();

        // 3.8 - Imprimir funcionários que fazem aniversário nos meses 10 e 12
        System.out.println("--- 3.8 - Aniversariantes de Outubro (10) e Dezembro (12) ---");
        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
                .forEach(f -> System.out.println("Nome: " + f.getNome() + ", Data de Aniversário: " + f.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        System.out.println();

        // 3.9 - Imprimir o funcionário com a maior idade
        System.out.println("--- 3.9 - Funcionário com a Maior Idade ---");
        Funcionario maisVelho = funcionarios.stream()
                .max(Comparator.comparingInt(f -> Period.between(f.getDataNascimento(), LocalDate.now()).getYears()))
                .orElse(null);

        if (maisVelho != null) {
            int idade = Period.between(maisVelho.getDataNascimento(), LocalDate.now()).getYears();
            System.out.println("Nome: " + maisVelho.getNome() + ", Idade: " + idade + " anos");
        }
        System.out.println();
        
        // 3.10 - Imprimir a lista de funcionários por ordem alfabética
        System.out.println("--- 3.10 - Funcionários em Ordem Alfabética ---");
        funcionarios.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach(f -> System.out.println(f.getNome()));
        System.out.println();
        
        // 3.11 - Imprimir o total dos salários
        System.out.println("--- 3.11 - Total dos Salários ---");
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total: " + formatarValor(totalSalarios));
        System.out.println();

        // 3.12 - Imprimir quantos salários mínimos cada funcionário ganha
        System.out.println("--- 3.12 - Salários Mínimos por Funcionário ---");
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        funcionarios.forEach(f -> {
            BigDecimal salariosMinimos = f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println("Nome: " + f.getNome() + ", Salários Mínimos: " + salariosMinimos);
        });
    }

    /**
     * Método utilitário para imprimir os funcionários com formatação.
     */
    private static void imprimirFuncionarios(List<Funcionario> lista) {
        for (Funcionario f : lista) {
            System.out.println("Nome: " + f.getNome() + 
                               ", Data de Nascimento: " + f.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                               ", Salário: " + formatarValor(f.getSalario()) +
                               ", Função: " + f.getFuncao());
        }
    }

    /**
     * Método utilitário para formatar valores numéricos.
     */
    private static String formatarValor(BigDecimal valor) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        symbols.setDecimalSeparator(',');
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,##0.00", symbols);
        return df.format(valor);
    }
}