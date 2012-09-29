using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Net;
using System.IO;

namespace RESTTests
{
    [TestClass]
    public class MensajesTest
    {
        [TestMethod]
        public void ObtenerSaludoTest()
        {
            HttpWebRequest req = WebRequest.Create("http://localhost:27695/Mensajes.svc/Saludos") as HttpWebRequest;
            HttpWebResponse res = req.GetResponse() as HttpWebResponse;
            StreamReader reader = new StreamReader(res.GetResponseStream());
            string saludo = reader.ReadToEnd();
            int hora = DateTime.Now.Hour;

            if (hora < 12)
                Assert.AreEqual(saludo, "\"Buenos días\"");
            else if (hora < 19)
                Assert.AreEqual(saludo, "\"Buenas tardes\"");
            else
                Assert.AreEqual(saludo, "\"Buenas noches\"");
        }
    }
}
