using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AutoItX3Lib;

namespace AutoTests {
    public class HelperBase {
        protected AppManager manager;
        protected AutoItX3 aux;
        protected static string CALCULATOR;

        public HelperBase(AppManager manager) {
            CALCULATOR = AppManager.CALCULATOR;

            this.manager = manager;
            this.aux = manager.Aux;
        }
    }
}
