(defproject metrics-riemann/metrics-riemann "0.1.0-SNAPSHOT" 
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [noir "1.3.0-beta1"]
                 [hiccup "1.0.0-beta1"]
                 [com.yammer.metrics/metrics-core "2.1.0"]]
  :main metrics-riemann.server
  :description "FIXME: write this!")