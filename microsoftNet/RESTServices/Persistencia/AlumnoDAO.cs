using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using RESTServices.Dominio;
using System.Data.SqlClient;

namespace RESTServices.Persistencia
{
    public class AlumnoDAO
    {
        public Alumno Crear(Alumno alumnoACrear)
        {
            Alumno alumnoCreado = null;
            string sql = "INSERT INTO t_alumno VALUES (@cod, @nom)";
            using (SqlConnection con = new SqlConnection(ConexionUtil.Cadena))
            {
                con.Open();
                using (SqlCommand com = new SqlCommand(sql, con))
                {
                    com.Parameters.Add(new SqlParameter("@cod", alumnoACrear.Codigo));
                    com.Parameters.Add(new SqlParameter("@nom", alumnoACrear.Nombre));
                    com.ExecuteNonQuery();
                }
            }
            alumnoCreado = Obtener(alumnoACrear.Codigo);
            return alumnoCreado;
        }

        public Alumno Obtener(string codigo)
        {
            Alumno alumnoEncontrado = null;
            string sql = "SELECT * FROM t_alumno WHERE codigo=@cod";
            using (SqlConnection con = new SqlConnection(ConexionUtil.Cadena))
            {
                con.Open();
                using (SqlCommand com = new SqlCommand(sql, con))
                {
                    com.Parameters.Add(new SqlParameter("@cod", codigo));
                    using (SqlDataReader resultado = com.ExecuteReader())
                    {
                        if (resultado.Read())
                        {
                            alumnoEncontrado = new Alumno()
                            {
                                Codigo = (string)resultado["codigo"],
                                Nombre = (string)resultado["nombre"]
                            };
                        }
                    }
                }
            }
            return alumnoEncontrado;
        }

        public Alumno Modificar(Alumno alumnoAModificar)
        {
            Alumno alumnoModificado = null;
            string sql = "UPDATE t_alumno SET nombre = @nom WHERE codigo = @cod";
            using (SqlConnection con = new SqlConnection(ConexionUtil.Cadena))
            {
                con.Open();
                using (SqlCommand com = new SqlCommand(sql, con))
                {
                    com.Parameters.Add(new SqlParameter("@cod", alumnoAModificar.Codigo));
                    com.Parameters.Add(new SqlParameter("@nom", alumnoAModificar.Nombre));
                    com.ExecuteNonQuery();
                }
            }
            alumnoModificado = Obtener(alumnoAModificar.Codigo);
            return alumnoModificado;
        }

        public void Eliminar(string codigo)
        {
            string sql = "DELETE FROM t_alumno WHERE codigo = @cod";
            using (SqlConnection con = new SqlConnection(ConexionUtil.Cadena))
            {
                con.Open();

                using (SqlCommand com = new SqlCommand(sql, con))
                {
                    com.Parameters.Add(new SqlParameter("@cod", codigo));
                    com.ExecuteNonQuery();
                }
            }
        }

        public List<Alumno> ListarTodos()
        {
            List<Alumno> alumnosListados = new List<Alumno>();
            Alumno alumnoEncontrado = null;
            string sql = "SELECT * FROM t_alumno";
            using (SqlConnection con = new SqlConnection(ConexionUtil.Cadena))
            {
                con.Open();
                using (SqlCommand com = new SqlCommand(sql, con))
                {
                    using (SqlDataReader resultado = com.ExecuteReader())
                    {
                       

                      while (resultado.Read())
                        {
                            alumnoEncontrado = new Alumno()
                            {
                                Codigo = (string)resultado["codigo"],
                                Nombre = (string)resultado["nombre"]
                            };
                            alumnosListados.Add(alumnoEncontrado);
                        }
                    }
                }
            }
            return alumnosListados;
        }
    }
}