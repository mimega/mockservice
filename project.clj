(defproject mockservice "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.3.442"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.3"] ; <-- needed
                 [http-kit "2.2.0"]
                 ; [org.clojure/tools.logging "0.3.1"]
                 ; [org.clojure/data.json "0.2.6"]
                 ; [ring/ring-json "0.4.0"]
                 ]
  :main ^:skip-aot mockservice.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
