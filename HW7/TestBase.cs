using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AutoItX3Lib;
using NUnit.Framework;

namespace AutoTests {
    public class TestBase {
        protected AppManager manager;

        [TestFixtureSetUp]
        public void InitTests() {
            manager = new AppManager();        
        }

        [TestFixtureTearDown]
        public void StopTests() {
            manager.Stop();
        }
    }
}
