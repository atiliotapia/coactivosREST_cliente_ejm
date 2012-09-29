using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using RESTServices.Dominio;
using RESTServices.Persistencia;

namespace RESTServices
{   
    public class Alumnos : IAlumnos
    {
        private AlumnoDAO dao = new AlumnoDAO();        

        public Alumno CrearAlumno(Alumno alumnoACrear)
        {
            return dao.Crear(alumnoACrear);
        }

        public Alumno ObtenerAlumno(string codigo)
        {
            return dao.Obtener(codigo);
        }

        public Alumno ModificarAlumno(Alumno alumnoAModificar)
        {
            return dao.Modificar(alumnoAModificar);
        }

        public void EliminarAlumno(string codigo)
        {
            dao.Eliminar(codigo);            
        }

        public List<Alumno> ListarAlumnos()
        {
            return dao.ListarTodos();
        }
    }
}
