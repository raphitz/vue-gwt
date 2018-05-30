/**
 * Process the Vue.js dev runtime and output lines of java
 * to be put in VueLibDevInjector
 */

const fs = require('fs'),
	javaStringSplitter = require('../java/java-string-splitter'),
	path = require('path');

const IN = path.join(__dirname, '..', 'node_modules', 'vue', 'dist', 'vue.runtime.min.js');
const OUT = path.join(__dirname, '..', 'out', 'VueLibInjector.java');

module.exports = function () {
	fs.readFile(IN, 'utf8', function (err, data) {
		if (err) throw err;

		const javaStringBuilder = javaStringSplitter.splitStringForJava(data, 'VUE_RUNTIME');
		fs.writeFile(OUT, `package com.axellience.vuegwt.core.client;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLScriptElement;

import static com.axellience.vuegwt.core.client.VueGWT.isVueLibInjected;

/**
This class is generated by utils/vue-runtime/vue-runtime.js
*/
class VueLibInjector
{
    static void ensureInjected()
    {
        if (isVueLibInjected())
            return;

        HTMLScriptElement scriptElement =
            (HTMLScriptElement) DomGlobal.document.createElement("script");
        scriptElement.text = VUE_RUNTIME;
        DomGlobal.document.body.appendChild(scriptElement);
    }

    /*!
     * Vue.js v2.5.16
     * (c) 2014-2018 Evan You
     * Released under the MIT License.
     */
    private static String VUE_RUNTIME;

    static
    {
    	${javaStringBuilder}
    }
}`, () => console.log('Process Vue Runtime SUCCESS'));
	});
};