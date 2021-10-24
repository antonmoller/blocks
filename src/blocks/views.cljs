(ns blocks.views
  (:require
   [re-frame.core :as re-frame]
   [reagent.core :as r]
   [blocks.subs :as subs]))


(defn create-block []
  (let [data? (r/atom true)]
    (fn []
      [:div {:style {:margin "auto"
                     :width "500px"
                     :height "500px"
                     :border "1px solid black"}}
       [:button
        {:on-click #(reset! data? true)}
        "Data"]
       [:button
        {:on-click #(reset! data? false)}
        "Visual"]
       (if @data?
         [:h1 "Data"]
         [:h1 "Visual"])])))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])
        create? (r/atom false)]
    (fn []
      [:div {:style {:width "1200px" :height "800px"}}
      (when @create?
        [create-block])
      ;;  [:div
      ;;   {:style {:display (if @create? "block" "none")
      ;;            :width "500px"
      ;;            :height "250px"
      ;;            :border "1px solid green"
      ;;            }}]
       [:button
        {:on-click #(swap! create? not)}
        "Create Block"]
       [:div {:style {:width "100%"
                      :height "100%"
                      :border "1px solid black"
                      :background "linear-gradient(90deg, #fbfae8 15px, transparent 1%) center, linear-gradient(#fbfae8 15px, transparent 1%) center, #ccc"
                      :background-size "16px 16px"}}
      ;; [:div {:style {:position "absolute"
      ;;                :left "100px"
      ;;                :top "100px"
      ;;                :width "100px"
      ;;                :height "100px"
      ;;                :border "1px solid red"}}]
        ]
       ])))

