export class User {
    public status: string;
    public cpf: string;
    public nome: string;
    public password: string;
    public cargo: string;
    public regiao: string;
    public token: string;
    public email: string;
    criarUsuario(cpf: string, password: string) {
        this.cpf = cpf;
        this.password = password;
    }
}
