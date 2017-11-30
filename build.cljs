(require 'lumo.build.api)

(defn transpile-to-js [out_file]
  (lumo.build.api/build "src" {:output-to out_file
                               :optimizations :simple
                               :target :nodejs}))

(defn export-handler [out_file]
  (.appendFileSync (js/require "fs")
    out_file
    "exports.handler = cljs_lambda.core.handler;"))

(let [out_file "index.js"]
  (comp
    (transpile-to-js out_file)
    (export-handler out_file)))
