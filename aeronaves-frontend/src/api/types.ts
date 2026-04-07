export type Fabricante = "EMBRAER" | "BOEING" | "AIRBUS";

export type AeronaveDTO = {
  id?: number;
  nome: string;              // (Modelo na tela)
  fabricante: Fabricante;    // (Marca na tela)
  anoFabricacao: number;     // (Ano na tela)
  descricao: string;
  vendido: boolean;
  createdAt?: string;
  updatedAt?: string;
};

export type Page<T> = {
  content: T[];
  number: number;        
  size: number;         
  totalElements: number;
  totalPages: number;
  first: boolean;
  last: boolean;
};

export type Aeronave = {
  id: number;
  nome: string;
  fabricante: Fabricante; // ajuste se houver mais fabricantes
  anoFabricacao: number;
  descricao: string;
  vendido: boolean;
  createdAt: string;   // ISO Date string
  updatedAt: string;   // ISO Date string
};

export type AeronavesPorDecada = {
  decada?: unknown;
  aeronaves: unknown[];
};


export type AeronaveResponse = {
  id?: number;
  nome: string;              // (Modelo na tela)
  fabricante: Fabricante;    // (Marca na tela)
  anoFabricacao: number;     // (Ano na tela)
  descricao: string;
  vendido: boolean;
  createdAt?: string;
  updatedAt?: string;
}

export type AeronavePorFabricanteDTO = {
  fabricante: Fabricante;
  aeronaveDTO: Aeronave[];
};
export type ResumoFabricante = {
   fabricante: Fabricante;
   quantidade: number;
};



