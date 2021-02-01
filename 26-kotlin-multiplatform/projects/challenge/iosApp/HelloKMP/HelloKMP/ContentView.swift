//
//  ContentView.swift
//  HelloKMP
//
//  Created by Victoria Gonda on 1/31/21.
//  Copyright © 2021 Razeware. All rights reserved.
//

import SwiftUI
import shared

struct ContentView: View {
    var body: some View {
        Text(Greeting().greeting())
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
