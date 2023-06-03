package com.excript.Farmacia;
import java.util.ArrayList;

public class CadastroDeClientes {
    private ArrayList<Cliente> listaCliente = new ArrayList<>();

    public boolean checaEmail(Cliente cliente) {
        for (int i = 0; i < listaCliente.size(); i++) {
            Cliente compara = listaCliente.get(i);
            if (cliente.getEmail().equals(compara.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public boolean checaTelefone(Cliente cliente) {
        for (int i = 0; i < listaCliente.size(); i++) {
            Cliente compara = listaCliente.get(i);
            if (cliente.getTelefone().equals(compara.getTelefone())) {
                return true;
            }
        }
        return false;
    }
    
    public void mostrarPontos(Cliente cliente) {
        cliente.mostrarPontos();
    }

    public void cadastrarCliente(Cliente cliente) {
        if (checaEmail(cliente)) {
            System.out.println("Este email já está sendo usado em outra conta.");
        } else if (checaTelefone(cliente)) {
            System.out.println("Este telefone já está sendo usado em outra conta");
        } else {
            listaCliente.add(cliente);
        }
    }

    public void removerCliente(Cliente cliente) {
        if (listaCliente.remove(cliente)) {
            System.out.println("Cliente removido");
        } else {
            System.out.println("Cliente não encontrado");
        }
    }

    public void atualizarEmail(Cliente cliente, String novoEmail) {
        for (Cliente compara : listaCliente) {
            if (cliente == compara) {
                compara.setEmail(novoEmail);
                System.out.println("Email atualizado");
                return;
            }
        }
        System.out.println("Cliente não encontrado");
    }

    public void atualizarTelefone(Cliente cliente, String novoTelefone) {
        for (Cliente compara : listaCliente) {
            if (cliente == compara) {
                compara.setTelefone(novoTelefone);
                System.out.println("Telefone atualizado");
                return;
            }
        }
        System.out.println("Cliente não encontrado");
    }
    
    public void mostrarDadosCliente(Cliente cliente) {
        cliente.mostrarDados();
    }

}
