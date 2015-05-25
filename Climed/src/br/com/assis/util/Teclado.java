/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.assis.util;

/**
 *
 * @author jr
 */
import java.util.Scanner;

public class Teclado {

	public static String le() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}

