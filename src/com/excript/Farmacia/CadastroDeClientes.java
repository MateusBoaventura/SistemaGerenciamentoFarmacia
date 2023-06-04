package com.excript.Farmacia;
import java.util.ArrayList;

public class CadastroDeClientes {
    private ArrayList<Cliente> listaCliente = new ArrayList<>(); // Criando uma lista de clientes

    public boolean checaEmail(Cliente cliente) {
        for (int i = 0; i < listaCliente.size(); i++) {
            Cliente compara = listaCliente.get(i); // Variavel compara que recebe o cliente na posicao i;
            if (cliente.getEmail().equals(compara.getEmail())) { // Ele compara se o email do cliente do parametro é igual ao email do cliente da posicao i do for
                return true; // retorna true se for
            }
        }
        return false; // retorna false se nao for
    }

    public boolean checaTelefone(Cliente cliente) {
        for (int i = 0; i < listaCliente.size(); i++) {
            Cliente compara = listaCliente.get(i); // Variavel compara que recebe o cliente na posicao i;
            if (cliente.getTelefone().equals(compara.getTelefone())) { // Ele compara se o telefone do cliente do parametro é igual ao telefone do cliente da posicao i do for

                return true;
            }
        }
        return false;
    }
    
    public void mostrarPontos(Cliente cliente) {
        cliente.mostrarPontos();
    }

    // Funcao para cadastrar cliente
    public void cadastrarCliente(Cliente cliente) {
        if (checaEmail(cliente)) { // Chama a funcao checaEmail, se ela retorna true:
            System.out.println("Este email já está sendo usado em outra conta.");
        } else if (checaTelefone(cliente)) { // Chama a funcao checaTelefone, se ela retorna true:
            System.out.println("Este telefone já está sendo usado em outra conta");
        } else {
            listaCliente.add(cliente); // Se o cliente tem um email e telefone diferente dos demais da lista, ele adiciona na lista
        }
    }

    // Funcao para remover cliente
    public void removerCliente(Cliente cliente) {
        if (listaCliente.remove(cliente)) { // Se na lista tiver o cliente que foi passado como parametro:
            System.out.println("Cliente removido");
        } else { // Se nao tiver:
            System.out.println("Cliente não encontrado");
        }
    }

    // Funcao para atualizarEmail
    public void atualizarEmail(Cliente cliente, String novoEmail) { // Recebe como parametro o cliente, e o novo email que quer atualizar
        for (Cliente compara : listaCliente) {
            if (cliente == compara) {
                compara.setEmail(novoEmail); // Coloca o novo email
                System.out.println("Email atualizado");
                return;
            }
        }
        System.out.println("Cliente não encontrado");
    }
    
    // Funcao para atualizarTelefone
    public void atualizarTelefone(Cliente cliente, String novoTelefone) { // Recebe como parametro o cliente, e o novo telefone que quer atualizar
        for (Cliente compara : listaCliente) {
            if (cliente == compara) {
                compara.setTelefone(novoTelefone); // Coloca o novo telefone
                System.out.println("Telefone atualizado");
                return;
            }
        }
        System.out.println("Cliente não encontrado");
    }
    
    // chama a funcao mostrarDados
    public void mostrarDadosCliente(Cliente cliente) {
        cliente.mostrarDados();
    }

}
